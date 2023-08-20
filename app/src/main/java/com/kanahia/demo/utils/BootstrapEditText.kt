package com.kanahia.demo.utils
import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import com.kanahia.demo.R


class BootstrapEditText(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var editText : EditText? = null

    init {
        inflate(context, R.layout.bootstrap_edit_text_layout, this);
       editText = findViewById(R.id.editText)
    }


}

