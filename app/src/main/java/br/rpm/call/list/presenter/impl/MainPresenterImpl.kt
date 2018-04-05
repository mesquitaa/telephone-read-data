package br.rpm.call.list.presenter.impl

import android.Manifest.permission.READ_CALL_LOG
import android.app.Activity
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.support.v4.app.ActivityCompat.checkSelfPermission
import android.support.v4.app.ActivityCompat.requestPermissions
import br.rpm.call.list.main.MainView
import br.rpm.call.list.main.adapter.CallDetailAdapter
import br.rpm.call.list.presenter.MainPresenter
import br.rpm.call.list.utils.TelephoneUtils

class MainPresenterImpl constructor(val view: MainView) : MainPresenter {
    override fun onFabClick(activity: Activity) {
        if (checkSelfPermission(activity, READ_CALL_LOG) != PERMISSION_GRANTED) {
            requestPermissions(activity, arrayOf(READ_CALL_LOG), 0)
        } else {
            val list = TelephoneUtils().trackCallDetails(activity)
            view.fillData(list)
        }
    }
}
