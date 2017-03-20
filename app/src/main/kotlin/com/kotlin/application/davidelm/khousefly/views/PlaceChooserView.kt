package com.kotlin.application.davidelm.khousefly.views

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.kotlin.application.davidelm.khousefly.R
import java.lang.ref.WeakReference

class PlaceChooserView : RelativeLayout {
    private var findButton: View? = null
    private var placeTextInput: TextInputLayout? = null
    private var filterTextInput: TextInputLayout? = null

    constructor(context: Context?) : super(context) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }


    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
            super(context, attrs, defStyleAttr, defStyleRes) {
        initView()
    }



    private fun initView() {
        View.inflate(context, R.layout.place_chooser_layout, this)
        findButton = findViewById(R.id.findButtonId)
        placeTextInput = findViewById(R.id.placeTextInputLayoutId) as TextInputLayout
        filterTextInput = findViewById(R.id.filterTextInputLayoutId) as TextInputLayout
    }

    fun setListener(lst: WeakReference<OnClickListener>) {
        findButton?.setOnClickListener(lst.get())
    }

    fun getPlace() : String {
        return placeTextInput?.editText?.text.toString()
    }

    fun getFilter() : String {
        return filterTextInput?.editText?.text.toString()
    }
}