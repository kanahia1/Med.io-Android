package com.kanahia.demo.bottomify


import android.view.Menu
import androidx.annotation.ColorRes
import com.kanahia.demo.R

class BottomifyParams {
    var menu: Menu? = null

    var activeColor: String= "#141B31"
    var passiveColor: String = "#9EA7B8"
    var pressedColor: String = "#141B31"

    var itemPadding: Float = 16f
    var itemPaddingTB : Float = 40f
    var itemTextSize : Float = 40f
    var animationDuration: Int = 300
    var endScale: Float = 0.95f
    var startScale: Float = 1f
}