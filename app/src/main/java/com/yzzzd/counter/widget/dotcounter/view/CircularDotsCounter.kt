package com.yzzzd.counter.widget.dotcounter.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import com.yzzzd.counter.R
import com.yzzzd.counter.widget.dotcounter.base.CircularAbstractView

/**
 * Created by @yzzzd on 24/08/12.
 */

class CircularDotsCounter : CircularAbstractView {

    constructor(context: Context) : super(context) {
        initCoordinates()
        initPaints()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
        initCoordinates()
        initPaints()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttributes(attrs)
        initCoordinates()
        initPaints()
    }

    override fun initAttributes(attrs: AttributeSet) {
        super.initAttributes(attrs)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularDotsCounter, 0, 0)

        this.bigCircleRadius = typedArray.getDimensionPixelSize(R.styleable.CircularDotsCounter_counter_bigCircleRadius, 60)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCircle(canvas)
    }

    private fun drawCircle(canvas: Canvas) {

        for (i in 0 until noOfDots) {

            if (i + 1 <= count) {
                canvas.drawCircle(dotsXCorArr[i], dotsYCorArr[i], radius.toFloat() + radiusShadow.toFloat(), selectedShadowCirclePaint?: return)
                canvas.drawCircle(dotsXCorArr[i], dotsYCorArr[i], radius.toFloat(), selectedCirclePaint ?: return)
            } else {
                canvas.drawCircle(dotsXCorArr[i], dotsYCorArr[i], radius.toFloat(), defaultCirclePaint ?: return)
            }

        }
    }
}
