package com.yzzzd.counter.widget.dotcounter.base

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

/**
 * Created by @yzzzd on 24/08/12.
 */

open class CircularAbstractView : DotsCounterBaseView {

    protected val noOfDots = 10

    private val SIN_18 = 0.3090f
    private val SIN_54 = 0.8090f
    private val SIN_36 = 0.5878f
    private val SIN_72 = 0.9510f

    lateinit var dotsYCorArr: FloatArray

    var bigCircleRadius: Int = 60

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun initCoordinates() {
        val sin18Radius = SIN_18 * bigCircleRadius
        val sin54Radius = SIN_54 * bigCircleRadius
        val sin36Radius = SIN_36 * bigCircleRadius
        val sin72Radius = SIN_72 * bigCircleRadius

        dotsXCorArr = FloatArray(noOfDots)
        dotsYCorArr = FloatArray(noOfDots)

        for (i in 0 until noOfDots) {
            dotsYCorArr[i] = (this.bigCircleRadius + radius + radiusShadow).toFloat()
            dotsXCorArr[i] = dotsYCorArr[i]
        }

        dotsXCorArr[0] = dotsXCorArr[0] + sin18Radius
        dotsXCorArr[1] = dotsXCorArr[1] + sin54Radius
        dotsXCorArr[2] = dotsXCorArr[2] + bigCircleRadius
        dotsXCorArr[3] = dotsXCorArr[3] + sin54Radius
        dotsXCorArr[4] = dotsXCorArr[4] + sin18Radius

        dotsXCorArr[5] = dotsXCorArr[5] - sin18Radius
        dotsXCorArr[6] = dotsXCorArr[6] - sin54Radius
        dotsXCorArr[7] = dotsXCorArr[7] - bigCircleRadius
        dotsXCorArr[8] = dotsXCorArr[8] - sin54Radius
        dotsXCorArr[9] = dotsXCorArr[9] - sin18Radius

        dotsYCorArr[0] = dotsYCorArr[0] - sin72Radius
        dotsYCorArr[1] = dotsYCorArr[1] - sin36Radius
        dotsYCorArr[3] = dotsYCorArr[3] + sin36Radius
        dotsYCorArr[4] = dotsYCorArr[4] + sin72Radius

        dotsYCorArr[5] = dotsYCorArr[5] + sin72Radius
        dotsYCorArr[6] = dotsYCorArr[6] + sin36Radius
        dotsYCorArr[8] = dotsYCorArr[8] - sin36Radius
        dotsYCorArr[9] = dotsYCorArr[9] - sin72Radius
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val calWidthHeight = 2 * bigCircleRadius + 2 * (radius + radiusShadow)
        setMeasuredDimension(calWidthHeight, calWidthHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (i in 0 until noOfDots) {
            defaultCirclePaint?.let {
                canvas.drawCircle(dotsXCorArr[i], dotsYCorArr[i], radius.toFloat(), it)
            }
        }
    }
}