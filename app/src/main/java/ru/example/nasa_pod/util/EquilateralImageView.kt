package ru.example.nasa_pod.util

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

//класс для отображения фотографий
class EquilateralImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}