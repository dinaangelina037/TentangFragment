package com.dina.tentangfragment.fragment

import android.app.Activity
import android.os.Bundle
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.dina.tentangfragment.Adapter.AdapterSlider
import com.dina.tentangfragment.Adapter.AdapterWisata
import com.dina.tentangfragment.R
import com.dina.tentangfragment.api.ApiConfig
import com.dina.tentangfragment.databinding.FragmentHomeBinding
import com.dina.tentangfragment.model.ResponseWisata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvWisata : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home,container,false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvWisata = view.findViewById(R.id.rv_wisata)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.carousel1)
        arrSlider.add(R.drawable.carousel2)
        arrSlider.add(R.drawable.carousel3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        getDataWisata()

        return view

    }

    private fun getDataWisata() {
        ApiConfig.instanceRetrofit.getWisata().enqueue(object : Callback<ResponseWisata> {
            override fun onResponse(
                call: Call<ResponseWisata>,
                response: Response<ResponseWisata>
            ) {
                if (response.isSuccessful) {
                    val responseWisata = response.body()
                    val wisata = responseWisata?.data
                    val adapterWisata = AdapterWisata(wisata)
                    rvWisata.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        (layoutManager as LinearLayoutManager).orientation =
                            LinearLayoutManager.HORIZONTAL
                        adapterWisata.notifyDataSetChanged()
                        adapter = adapterWisata
                    }
                }
            }
            override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                Toast.makeText(activity,t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }


}


