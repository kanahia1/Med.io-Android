package com.kanahia.demo.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import com.kanahia.demo.R

class CustomButton(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {


    init {
        inflate(context, R.layout.custom_button, this);
    }

    fun setOnClick(function: () -> (Unit)){
        this.setOnClickListener {

            function()
        }

    }


}