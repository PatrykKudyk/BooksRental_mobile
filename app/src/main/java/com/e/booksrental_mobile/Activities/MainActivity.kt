package com.e.booksrental_mobile.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.e.booksrental_mobile.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        },2800)
    }

    override fun onBackPressed() {

    }
}
