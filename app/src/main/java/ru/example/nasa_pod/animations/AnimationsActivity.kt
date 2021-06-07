package ru.example.nasa_pod.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import kotlinx.android.synthetic.main.activity_animations_fab.*
import ru.example.nasa_pod.R

class AnimationsActivity : AppCompatActivity() {
    private var isExpanded = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations_fab)
        setFAB()
        scroll_view.setOnScrollChangeListener { _, _, _, _, _ -> //игнорим приходящие параметры
            toolbar.isSelected = scroll_view.canScrollVertically(-1) //проверяем можно ли скроллить
        }
    }

    private fun setFAB() {
        setInitialState()
        fab.setOnClickListener {
            if (isExpanded) { //проверяет открыта менюшка или нет.
                collapseFab()
            } else {
                expandFAB()
            }
        }
    }

    private fun setInitialState() {
        transparent_background.apply {
            alpha = 0f
        }
        option_two_container.apply {
            alpha = 0f
            isClickable = false
        }
        option_one_container.apply {
            alpha = 0f
            isClickable = false
        }
    }

    private fun expandFAB() {
        isExpanded = true
        val objAnimator = ObjectAnimator.ofFloat(plus_imageview, "rotation", 0f, 360f)
            .setDuration(1000L) //время анимации
        objAnimator.setInterpolator(BounceInterpolator())
        objAnimator.start()
        //высота итемов ручками подбирается
        ObjectAnimator.ofFloat(option_two_container, "translationY", -130f).start()
        ObjectAnimator.ofFloat(option_one_container, "translationY", -250f).start()

        option_two_container.animate()
            .alpha(1f)
            .rotation(360f)
            .setDuration(1000)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_two_container.isClickable = true
                    option_two_container.setOnClickListener {
                        Toast.makeText(this@AnimationsActivity, "Option 2", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        option_one_container.animate()
            .alpha(1f)
            .rotation(360f)
            .setDuration(1000L)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_one_container.isClickable = true
                    option_one_container.setOnClickListener {
                        Toast.makeText(this@AnimationsActivity, "Option 1", Toast.LENGTH_SHORT)
                            .show()
                    }
                    option_one_container.rotation = 0f
                }
            })
        transparent_background.animate()
            .alpha(0.9f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    transparent_background.isClickable = true
                }
            })
    }

    private fun collapseFab() {
        isExpanded = false
        ObjectAnimator.ofFloat(plus_imageview, "rotation", 0f, -180f).start()
        ObjectAnimator.ofFloat(option_two_container, "translationY", 0f).start()
        ObjectAnimator.ofFloat(option_one_container, "translationY", 0f).start()

        option_two_container.animate()
            .alpha(0f)
            .rotation(0f)
            .setDuration(1000)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_two_container.isClickable = false
                    option_one_container.setOnClickListener(null)
                }
            })
        option_one_container.animate()
            .alpha(0f)
            //.rotation(0f)
            .setDuration(1000)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    option_one_container.isClickable = false
                }
            })
        transparent_background.animate()
            .alpha(0f)
            .setDuration(1000)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    transparent_background.isClickable = false
                }
            })
    }
}