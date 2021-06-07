package ru.example.nasa_pod.ui.apibottom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_api_bottom.*
import ru.example.nasa_pod.R
import ru.example.nasa_pod.ui.api.EarthFragment
import ru.example.nasa_pod.ui.api.MarsFragment
import ru.example.nasa_pod.ui.api.WeatherFragment

class ApiBottomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_bottom)
        //обработка кликов
        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_api_bottom_container, EarthFragment())
                        .commitAllowingStateLoss()
                }
                R.id.bottom_view_mars -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_api_bottom_container, MarsFragment())
                        .commitAllowingStateLoss()
                }
                R.id.bottom_view_weather -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_api_bottom_container, WeatherFragment())
                        .commitAllowingStateLoss()
                }
                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_api_bottom_container, EarthFragment())
                        .commitAllowingStateLoss()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        //выбор первого отображвемого элемента
        bottom_navigation_view.selectedItemId = R.id.bottom_view_earth
        //бейдж. Берем готовый или создаем новый
        val badge = bottom_navigation_view.getOrCreateBadge(R.id.bottom_view_earth)
        badge.maxCharacterCount = 3
        badge.number = 100
        val badge2 = bottom_navigation_view.getOrCreateBadge(R.id.bottom_view_mars)
        badge2.maxCharacterCount = 2
        badge2.number = 7
        //пустой бейдж
        val badge3 = bottom_navigation_view.getOrCreateBadge(R.id.bottom_view_weather)
        badge3.maxCharacterCount = 3
        //реселектор
        bottom_navigation_view.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_earth -> {
                    //Item tapped
                }
                R.id.bottom_view_mars -> {
                    //Item tapped
                }
                R.id.bottom_view_weather -> {
                    //Item tapped
                }
            }
        }
    }
}