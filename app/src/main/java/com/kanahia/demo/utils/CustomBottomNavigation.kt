package com.kanahia.demo.utils


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet

import android.view.View
import androidx.core.content.ContextCompat


public class CustomBottomNavigation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    // val background = ColorDrawable()
    var items = 6
    var paddings = 5
    private var selectedItem = 0
    private lateinit var mSelectedImage: Drawable
    private lateinit var mNotSelectedImage: Drawable
    private lateinit var canvas2: Canvas



    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {


        // val selectedItemBitmap = ContextCompat.getDrawable(context,R.drawable.splash_screen_image1)?.let { drawableToBitmap(it) }

        mSelectedImage = context.resources.getDrawable(R.drawable.selected_item_toolbar)
        mNotSelectedImage = context.resources.getDrawable(R.drawable.item_nselected_toolbar)

        val bounds: Rect = canvas!!.clipBounds

        val width = bounds.width() / items

        val paddingWidth = width* paddingRatio


        if (canvas != null) {
            this.canvas2 = canvas
            for (i in 1..items){
                if (i == 1){
                    if(i == (selectedItem+1)){
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
                }else if(i == items){
                    if(i == (selectedItem+1)){
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
                else{
                    if(i == (selectedItem+1)){
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