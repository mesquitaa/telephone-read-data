package br.rpm.call.list.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Calendar;

import br.rpm.call.list.service.PhoneCheckService;

public class PhoneCheckReceiver extends WakefulBroadcastReceiver {

	private AlarmManager alarmMgr;
	private PendingIntent alarmIntent;

	public PhoneCheckReceiver() {}

	public static void startReceiver(Context context) {
		new PhoneCheckReceiver().setAlarm(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent service = new Intent(context, PhoneCheckService.class);
		startWakefulService(context, service);
	}

	public void setAlarm(Context context) {
		alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, PhoneCheckReceiver.class);
		alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());

		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 0);

		alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);

		ComponentName receiver = new ComponentName(context, BootReceiver.class);
		PackageManager pm = context.getPackageManager();

		pm.setComponentEnabledSetting(receiver, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
	}
}
