package com.example.rxkotlin.views.splash_screen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxkotlin.R
import com.example.rxkotlin.views.main.MainActivity
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class SplashScreenActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Single.timer(5, TimeUnit.SECONDS).subscribe { _ -> changeActivity() }
    }

    private fun changeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
