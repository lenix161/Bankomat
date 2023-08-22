package com.example.bankomatsimulator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class PowerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.v("power", "off")
        if(Intent.ACTION_POWER_DISCONNECTED == intent.action){
            Log.v("power", "off")
            val message = "Зарядка отключена"
            val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast.show()
        }

    }

}
