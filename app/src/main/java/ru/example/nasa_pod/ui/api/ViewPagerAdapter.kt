package ru.example.nasa_pod.ui.api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.lang.IllegalStateException

private const val EARTH_FRAGMENT = 0
private const val MARS_FRAGMENT = 1
private const val WEATHER_FRAGMENT = 2

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    //плохая реализация, сосдаются три фрагмента и висят в памяти. Для трех сойдет
    private val fragments = arrayOf(EarthFragment(), MarsFragment(), WeatherFragment())

    //возвращает фрагмент
    override fun getItem(position: Int): Fragment {
        //этот вариант подойдет когда много табов
        return when (position % fragments.size) {
            0 -> EarthFragment()
            1 -> MarsFragment()
            2 -> WeatherFragment()
            else -> throw IllegalStateException("Ставь дайк, если дочитал до сюда) Got $position ,but there are only ${fragments.size}")
        }
/*      Эта реализация хуже, в варианте сверху передается инстанс
        return when (position) {
            0 -> fragments[EARTH_FRAGMENT]
            1 -> fragments[MARS_FRAGMENT]
            2 -> fragments[WEATHER_FRAGMENT]
            else -> throw IllegalStateException("Этого не должно было произойти :) Получили позицию $position ,но здесь только ${fragments.size}")
        }*/
    }

    //считает количество табов
    override fun getCount(): Int {
        return fragments.size
    }
    //возвращает заголовок
    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }
}

