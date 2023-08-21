package com.kanahia.demo.bottomify


import android.view.Menu
import androidx.annotation.ColorRes
import com.kanahia.demo.R

class BottomifyParams {
    var menu: Menu? = null

    var activeColor: String= "#F9FAFE"
    var passiveColor: String = "#AFB0B4"
    var pressedColor: String = "#2E2F33"

    var itemPadding: Float = 16f
    var itemTextSize : Float = 40f
    var animationDuration: Int = 300
    var endScale: Float = 0.95f
    var startScale: Float = 1f
}