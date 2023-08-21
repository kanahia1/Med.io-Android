package com.kanahia.demo.utils


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.drawable.DrawableCompat
import com.kanahia.demo.R


public class CustomBottomNavigation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    // val background = ColorDrawable()
    var items = 4
    var paddings = 3
    private var selectedItem = 1

    private lateinit var mSelectedImage : Drawable
    private lateinit var mNotSelectedImage : Drawable
    private lateinit var canvas2: Canvas
    private val drawables = arrayListOf<Int>()

    init {
        drawables.add(0,R.drawable.home)
        drawables.add(1,R.drawable.calendar)
        drawables.add(2,R.drawable.chat)
        drawables.add(3,R.drawable.profile)
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {


        // val selectedItemBitmap = ContextCompat.getDrawable(context,R.drawable.splash_screen_image1)?.let { drawableToBitmap(it) }

       // mSelectedImage = context.resources.getDrawable(R.drawable.selected_item_toolbar)
       // mSelectedImage = context.resources.getDrawable(R.drawable.item_nselected_toolbar)

        val bounds: Rect = canvas!!.clipBounds

        val width = bounds.width() / items

        val paddingWidth = width* paddingRatio


        if (canvas != null) {
            this.canvas2 = canvas

            for (i in 1..items){

                mNotSelectedImage = context.resources.getDrawable(drawables[i-1])
                var m = context.resources.getDrawable(drawables[i-1])
                mSelectedImage = DrawableCompat.wrap(m)
                DrawableCompat.setTint(mSelectedImage, Color.parseColor("#141B31"))

                if (i == 1){
                    if(i == (selectedItem)){
                        mSelectedImage.setBounds(
                            Rect(
                                bounds.left ,
                                bounds.top,
                                bounds.left + width * i ,
                                bounds.bottom
                            )
                        )
                        mSelectedImage.draw(canvas)
                    }else{
                        mNotSelectedImage.setBounds(
                            Rect(
                                bounds.left ,
                                bounds.top,
                                bounds.left + width * i ,
                                bounds.bottom
                            )
                        )
                        mNotSelectedImage.draw(canvas)
                    }
                }
                else{
                    if(i == (selectedItem)){
                        mSelectedImage.setBounds(
                            Rect(
                                bounds.left + width * (i-1) +paddingWidth.toInt(),
                                bounds.top,
                                bounds.left + width * i ,
                                bounds.bottom
                            )
                        )
                        mSelectedImage.draw(canvas)
                    }else{
                        mNotSelectedImage.setBounds(
                            Rect(
                                bounds.left + width * (i-1)+paddingWidth.toInt(),
                                bounds.top,
                                bounds.left + width * i ,
                                bounds.bottom
                            )
                        )
                        mNotSelectedImage.draw(canvas)
                    }
                }


            }
        }
        super.onDraw(canvas)

    }
    fun setNumberOfItems(items:Int){
        this.items = items
        this.paddings = items -1
        invalidate()
    }

    fun setSelectedItemIn(itemN : Int){
        if(itemN < items){
            selectedItem = itemN
            invalidate()
        }
    }

    companion object{
        val paddingRatio = 0.065
    }
}