package com.mewz.customeviewassignment.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.mewz.customeviewassignment.R

class RoundedProfileImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    private var cornerRadius = 0f
    private val path = Path()

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    companion object{
        private const val DEFAULT_BORDER_WIDTH = 8.0f
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
    }

    private val borderColor = DEFAULT_BORDER_COLOR
    private val borderWidth = DEFAULT_BORDER_WIDTH

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedProfileImageView){
            cornerRadius = getDimension(R.styleable.RoundedProfileImageView_cornerRadius, 0f)
        }
    }

    override fun onDraw(canvas: Canvas?) {

        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)
        canvas?.clipPath(path)

        super.onDraw(canvas)

        onDrawProfileImageBorderCircle(canvas)


    }

    private fun onDrawProfileImageBorderCircle(canvas: Canvas?) {
        paint.apply {
            color = borderColor
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
        }
        canvas?.drawCircle(width / 2f, height / 2f, cornerRadius - borderWidth / 2f, paint)
    }

}