package com.example.intentserviceexample

import android.app.AlertDialog
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.PowerManager
import android.os.SystemClock
import androidx.annotation.Nullable
import androidx.core.app.NotificationCompat

class IntentServiceEx : IntentService("IntentServiceEX") {
    lateinit var wl: PowerManager.WakeLock

    init {
        setIntentRedelivery(true)
    }

    override fun onCreate() {
        super.onCreate()
        var pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "wakelock: stated")
        wl.acquire()
    }

    override fun onHandleIntent(@Nullable intent: Intent?) {
        var input = intent?.getStringExtra("input")

        var n = NotificationCompat.Builder(this, "ch1")
            .setContentTitle(input)
            .setContentText("Running...")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()
        startForeground(1, n)
        SystemClock.sleep(6000)
    }

    override fun onDestroy() {
        super.onDestroy()
        wl.release()
    }
}