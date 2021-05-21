package ru.example.nasa_pod.settings

import ru.example.nasa_pod.R

const val APP_THEME_CHOOSEN = "APP_THEME_CHOOSEN"
const val APP_THEME_SAVED = "APP_THEME_SAVED"
const val MAIN_THEME = 0
const val RED_THEME = 1
const val PREFERENCE_NAME = "NASA_POD"
fun getAppTheme(themeID: Int): Int =
    when (themeID) {
        MAIN_THEME -> R.style.Theme_NASA_POD
        RED_THEME -> R.style.RedTheme
        else -> R.style.Theme_NASA_POD
    }