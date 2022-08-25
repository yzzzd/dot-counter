package com.yzzzd.counter.widget.dotcounter.base

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.yzzzd.counter.R

/**
 * Created by @yzzzd on 24/08/12.
 */

abstract class DotsCounterBaseView : View, CounterContract {

    lateinit var dotsXCorArr: FloatArray

    protected var defaultCirclePaint: Paint? = null
    protected var selectedCirclePaint: Paint? = null
    protected var selectedShadowCirclePaint: Paint? = null

    protected var count = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun initAttributes(attrs: AttributeSet) {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DotsCounterBaseView, 0, 0)

        this.defaultColor = typedArray.getColor(R.styleable.DotsCounterBaseView_counter_defaultColor, ContextCompat.getColor(context, R.color.loader_default))
        this.selectedColor = typedArray.getColor(R.styleable.DotsCounterBaseView_counter_selectedColor, ContextCompat.getColor(context, R.color.loader_selected))
        this.selectedColorShadow = typedArray.getColor(R.styleable.DotsCounterBaseView_counter_selectedColorShadow, ContextCompat.getColor(context, R.color.loader_selected_shadow))

        this.radius = typedArray.getDimensionPixelSize(R.styleable.DotsCounterBaseView_counter_circleRadius, 30)
        this.radiusShadow = typedArray.getDimensionPixelSize(R.styleable.DotsCounterBaseView_counter_circleRadiusShadow, 12)

        typedArray.recycle()
    }

    protected abstract fun initCoordinates()

    //init paints for drawing dots
    fun initPaints() {
        defaultCirclePaint = Paint()
        defaultCirclePaint?.isAntiAlias = true
        defaultCirclePaint?.style = Paint.Style.FILL
        defaultCirclePaint?.color = defaultColor

        selectedCirclePaint = Paint()
        selectedCirclePaint?.isAntiAlias = true
        selectedCirclePaint?.style = Paint.Style.FILL
        selectedCirclePaint?.color = selectedColor

        selectedShadowCirclePaint = Paint()
        selectedShadowCirclePaint?.isAntiAlias = true
        selectedShadowCirclePaint?.style = Paint.Style.FILL
        selectedShadowCirclePaint?.color = selectedColorShadow
    }

    fun setCounter(count: Int) {
        this.count = count
        invalidate()
    }

    var defaultColor: Int = ContextCompat.getColor(context, R.color.loader_default)
        set(defaultColor) {
            field = defaultColor
            defaultCirclePaint?.color = defaultColor
        }

    open var selectedColor: Int = ContextCompat.getColor(context, R.color.loader_selected)
        set(selectedColor) {
            field = selectedColor
            selectedCirclePaint?.let {
                it.color = selectedColor
            }
        }

    open var selectedColorShadow: Int = ContextCompat.getColor(context, R.color.loader_selected_shadow)
        set(selectedColorShadow) {
            field = selectedColorShadow
            selectedShadowCirclePaint?.let {
                it.color = selectedColorShadow
            }
        }

    var radius: Int = 30
        set(radius) {
            field = radius
            initCoordinates()
        }

    var radiusShadow: Int = 12
        set(radiusShadow) {
            field = radiusShadow
            initCoordinates()
        }
}