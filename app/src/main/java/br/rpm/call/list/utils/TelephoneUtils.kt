package br.rpm.call.list.utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.util.Log

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Collections
import java.util.Date
import java.util.HashMap
import java.util.Locale
import java.util.TimeZone

import br.rpm.call.list.model.CallDetail

import android.provider.CallLog.Calls

class TelephoneUtils {

    // @field:Inject lateinit var mTracker: Tracker
    // @field:Inject lateinit var mDao: CallDetailDAO

    @SuppressLint("MissingPermission")
    fun trackCallDetails(context: Context): List<CallDetail> {
        val details = ArrayList<CallDetail>()

        val order = Calls.DATE + " DESC"
        val selections = Calls.CACHED_NAME + " like ? AND " + Calls.DATE + " > ?"

        // Put here the timestamp that you send to server CallDetails
        // val lastDate = mDao.getLastDate();
        val lastDate = "0"

        // If you need check a specific user name change the first attribute
        val selectionArg = arrayOf("%%", lastDate)

        // It's necessary guarantee that user has permission, avoiding Android attempt to show dialog in a service
        val cursor = context.contentResolver.query(Calls.CONTENT_URI, null, selections, selectionArg, order) ?: return details

        while (cursor.moveToNext()) {
            val detail = CallDetail()
            detail.callType = getCallType(cursor.getInt(cursor.getColumnIndex(Calls.TYPE)))
            detail.number = cursor.getString(cursor.getColumnIndex(Calls.NUMBER))
            detail.name = cursor.getString(cursor.getColumnIndex(Calls.CACHED_NAME))
            detail.duration = cursor.getString(cursor.getColumnIndex(Calls.DURATION))
            detail.date = convertData(cursor.getString(cursor.getColumnIndex(Calls.DATE)))

            // If you need it's possible track here the call, avoiding return a list
            // mTracker.trackCallDetail(detail);

            details.add(detail)
        }

        // Save the last date that you read a contact list, avoiding send to server the same values
        // mDao.setLastCallDetail(getTimeInMillis());

        cursor.close()

        return details
    }

    private fun convertData(date: String): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        return formatter.format(Date(java.lang.Long.valueOf(date)))
    }

    enum class Type constructor(value: String) {
        OUTGOING_TYPE("Outgoing"),
        INCOMING_TYPE("Incoming"),
        MISSED_TYPE("Missed"),
        UNKNOWN_TYPE("Unknown");

        var value: String
            internal set

        init {
            this.value = value
        }
    }

    private fun getCallType(callTypeCode: Int): String = when (callTypeCode) {
        Calls.OUTGOING_TYPE -> Type.OUTGOING_TYPE.value
        Calls.INCOMING_TYPE -> Type.INCOMING_TYPE.value
        Calls.MISSED_TYPE -> Type.MISSED_TYPE.value
        else -> Type.UNKNOWN_TYPE.value
    }
}
