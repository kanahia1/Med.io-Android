package com.kanahia.demo.utils
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.kanahia.demo.R


class BootstrapEditText(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var editText : EditText? = null
    var background : LinearLayout? = null
    var fore : LinearLayout? = null

    init {
        inflate(context, R.layout.bootstrap_edit_text_layout, this)
        editText = findViewById(R.id.editText)
        background = findViewById(R.id.bootstrapEditTextBack)
        fore = findViewById(R.id.bootstrapEditTextFore)

        editText!!.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                background!!.background = context?.let { ContextCompat.getDrawable(it,R.drawable.bootstrap_edit_text_selected_background) }
                fore!!.background = context?.let { ContextCompat.getDrawable(it,R.drawable.bootstrap_edit_text_selected) }
            }else{
                background!!.background = context?.let { ContextCompat.getDrawable(it,R.drawable.bootstrap_edit_text_not_selected_background) }
                fore!!.background = context?.let { ContextCompat.getDrawable(it,R.drawable.bootstrap_edit_text_not_selected) }
            }
        }
    }





    fun getText(): String {
        return editText!!.text.toString()
    }


}

