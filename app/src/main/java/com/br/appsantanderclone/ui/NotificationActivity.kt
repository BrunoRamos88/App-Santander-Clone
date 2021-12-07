package com.br.appsantanderclone.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.br.appsantanderclone.R
import com.google.android.material.appbar.MaterialToolbar

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        setSupportActionBar(findViewById(R.id.toolbar_notification))
        toolbarActions()
        actionButtons()
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.config_notification_menu, menu)
        return true
    }
    private fun toolbarActions() {
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar_notification)
        toolbar.setNavigationOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.settings -> {
                    showToast("Configurações de Notificações")
                    true
                }
                else -> false
            }
        }

    }

    private fun actionButtons() {

        val button1 = findViewById<ImageButton>(R.id.iv_open_confirmation)
        val button2 = findViewById<ImageButton>(R.id.iv_general_notification)

        button1.setOnClickListener {
            showToast("Confirmações em aberto")
        }

        button2.setOnClickListener {
            showToast("Notificações gerais")
        }


    }
}