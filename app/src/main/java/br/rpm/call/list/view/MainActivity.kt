package br.rpm.call.list.view

import android.Manifest.permission.READ_CALL_LOG
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import br.rpm.call.list.R
import br.rpm.call.list.utils.TelephoneUtils

import kotlinx.android.synthetic.main.act_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->
            if (ActivityCompat.checkSelfPermission(this, READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(this, arrayOf(READ_CALL_LOG), 0)
            } else {
                TelephoneUtils().trackCallDetails(this)
            }
        }
    }
}
