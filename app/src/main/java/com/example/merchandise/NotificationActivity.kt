package com.example.merchandise

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat
import com.example.merchandise.databinding.ActivityNotificationBinding
import com.example.merchandise.databinding.FragmentProfileBinding

class NotificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding

    companion object {
        private const val NOTIFICATION_CHANNEL_ID = "channel_id"
        private const val NOTIFICATION_CHANNEL_NAME = "channel_name"
        private const val NOTIFICATION_ID = 1
        private const val REQUEST_NOTIFICATION_PERMISSION = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener{
            finish()
        }



        // Проверяем, есть ли уже разрешение на отправку уведомлений
        if (!areNotificationsEnabled()) {
            // Если разрешения нет, запрашиваем его
            requestNotificationPermission()
        } else {
            // Если разрешение уже предоставлено, можно отправить уведомление
            sendNotification()
        }
    }

    private fun areNotificationsEnabled(): Boolean {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return NotificationManagerCompat.from(this).areNotificationsEnabled() &&
                (Build.VERSION.SDK_INT < Build.VERSION_CODES.O || notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID) != null)
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Создаем канал уведомлений (должно быть выполнено до создания уведомления)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        // Открываем системные настройки уведомлений для данного приложения
        val intent = Intent().apply {
            action = android.provider.Settings.ACTION_APP_NOTIFICATION_SETTINGS
            putExtra(android.provider.Settings.EXTRA_APP_PACKAGE, packageName)
        }
        startActivityForResult(intent, REQUEST_NOTIFICATION_PERMISSION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_NOTIFICATION_PERMISSION) {
            if (areNotificationsEnabled()) {
                // Если разрешение было предоставлено, отправляем уведомление
                sendNotification()
            } else {
                // Если разрешение не было предоставлено, можно выполнить необходимые действия или вывести сообщение об ошибке
            }
        }
    }

    private fun sendNotification() {
        // Отправляем уведомление
        val notificationManager = NotificationManagerCompat.from(this)
        
    }

}

