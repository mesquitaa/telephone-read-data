package br.rpm.call.list.service

import android.app.IntentService
import android.content.Intent

import br.rpm.call.list.receiver.PhoneCheckReceiver.completeWakefulIntent

import br.rpm.call.list.utils.TelephoneUtils

class PhoneCheckService : IntentService("PhoneCheckService") {
    override fun onHandleIntent(intent: Intent?) {
        TelephoneUtils().trackCallDetails(baseContext)

        completeWakefulIntent(intent)
    }
}
