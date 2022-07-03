package com.dina.tentangfragment.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dina.tentangfragment.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        mainButton()
    }

    private fun mainButton() {
        btn_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_regis.setOnClickListener {
            val i = Intent(this, DaftarActivity::class.java)
            startActivity(i)
        }
    }
}