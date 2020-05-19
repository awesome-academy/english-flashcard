package com.sunasterisk.englishflashcard.ui.splashscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.ui.main.MainActivity

class SplashScreen : AppCompatActivity() {

    companion object {
        const val TIME_LOAD = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val time: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(TIME_LOAD.toLong())
                } catch (e: Exception) {
                } finally {
                    startActivity(MainActivity.getIntent(this@SplashScreen))
                    finish()
                }
            }
        }
        time.start()
    }
}
