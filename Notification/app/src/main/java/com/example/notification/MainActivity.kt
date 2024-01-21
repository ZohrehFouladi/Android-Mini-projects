package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.databinding.ActivityMainBinding
import android.app.PendingIntent.FLAG_IMMUTABLE

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var CHANNEL_ID = "com.example.notification_01"
    private var notificationID = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        creatNotificationChannel()
        binding.buttonSendNotification.setOnClickListener() {
            sendNotification()
        }
    }

    fun creatNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "shopping"
            val descriptionText = "shopping sedcription"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = descriptionText
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }


    }

    fun sendNotification() {

        val intent= Intent(this,MainActivity::class.java)
        val pendingIntent:PendingIntent=PendingIntent.getActivity(
            this,0,intent,PendingIntent.FLAG_IMMUTABLE)
        val bitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ic_launcher_background)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_monetization_on_24)
            .setLargeIcon((bitmap))
            .setContentTitle("shopping successfully ")
            .setStyle(NotificationCompat.BigTextStyle().bigText("*********************************************************************"))
            .setContentText("kharid ba movafaghiyat anjam shod")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)) {
            builder.setChannelId(CHANNEL_ID)
            notify(notificationID, builder.build())
        }

    }
}