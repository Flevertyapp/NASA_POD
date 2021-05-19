package ru.example.nasa_pod.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.example.nasa_pod.R
import ru.example.nasa_pod.ui.main.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}