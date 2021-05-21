package ru.example.nasa_pod.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.example.nasa_pod.R
import ru.example.nasa_pod.settings.*
import ru.example.nasa_pod.ui.main.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    var themeChoosen: Int? = null
    var themeSaved: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        themeSaved = getAppThemeSaved(MAIN_THEME)
        themeChoosen = getAppThemeChoosen(MAIN_THEME)
        themeChoosen?.let { setTheme(getAppTheme(it)) }
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }

    private fun getAppThemeChoosen(appThemeDefault: Int): Int {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        return sharedPreferences.getInt(APP_THEME_CHOOSEN, appThemeDefault)
    }

    private fun getAppThemeSaved(appThemeDefault: Int): Int {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        return sharedPreferences.getInt(APP_THEME_CHOOSEN, appThemeDefault)
    }

    fun setAppTheme() {
        with(getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE).edit()) {
            putInt(APP_THEME_CHOOSEN, themeChoosen!!)
            putInt(APP_THEME_SAVED, themeSaved!!)
            apply()
        }
    }
}