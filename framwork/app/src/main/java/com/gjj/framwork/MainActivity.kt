package com.gjj.framwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val MAX_TAG_NUM = 10
    private val MAX_ROW = 2
    private val MAX_COLUMN = 5
    private val MAX_ITEM_HEIGHT_NUMBER = 86f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initGridLayout()
    }

    fun test(view: View, listener: View.OnClickListener) {
        view.setOnClickListener {
            listener.onClick(it)
        }
    }

    private fun initGridLayout() {

//        gridLayout.columnCount = 2
//        gridLayout.rowCount = 5

        var size = getWidth() / 5
        for (row in 0 until MAX_ROW) {
            for (column in 0 until MAX_COLUMN) {
                val index = column + row * MAX_COLUMN
                if (index >= 10) {
                    return
                }
                val columnSpec = GridLayout.spec(column, 0f)
                val rowSpec = GridLayout.spec(row, 0f)
                val layoutParams = GridLayout.LayoutParams(rowSpec, columnSpec).apply {
                    height = size
                    width = size
                }
                val view = LayoutInflater.from(this).inflate(R.layout.item_grid, null, false)
                gridLayout.addView(view, layoutParams)
            }
        }
    }


    private fun getWidth(): Int {
        val display = windowManager.defaultDisplay
        val width = display.width
        val height = display.height
        return width
    }
}