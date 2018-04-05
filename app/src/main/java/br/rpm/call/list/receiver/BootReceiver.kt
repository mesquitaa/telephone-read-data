package br.rpm.call.list.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.rpm.call.list.receiver.PhoneCheckReceiver.startReceiver

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Intent.ACTION_BOOT_COMPLETED != intent.action) return

        startReceiver(context)
    }
}
