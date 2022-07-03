package com.dina.tentangfragment.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.dina.tentangfragment.R

class AdapterSlider(var data: ArrayList<Int>, var context: Activity?) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    @NonNull
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.items_row_slider, container,false)

        val imageView: ImageView
        imageView =view.findViewById(R.id.img_slider)

        imageView.setImageResource(data[position])
        container.addView(view,0)

        return view
    }

    override fun destroyItem(@NonNull container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
