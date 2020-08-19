package com.gjj.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_test.*

/**
 * author: gujingjing
 * created on: 2020/8/17 1:16 PM
 * description:
 */
class RecyclerViewTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val data = ArrayList<String>()
        for (i in 0..200) {
            data.add(i.toString())
        }
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = MainTestAdapter(data)
        recyclerView.adapter = adapter
    }
}