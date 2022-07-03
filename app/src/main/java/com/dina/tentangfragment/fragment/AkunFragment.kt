package com.dina.tentangfragment.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.dina.tentangfragment.R
import com.dina.tentangfragment.activity.WelcomeActivity
import com.dina.tentangfragment.helper.SharedPreference


class AkunFragment : Fragment() {


    lateinit var sharedPreference: SharedPreference
    lateinit var tvLogout: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)

        init(view)

        sharedPreference = SharedPreference(context as Activity)

        tvLogout.setOnClickListener {
            sharedPreference.setStatusLogin(false)
            Toast.makeText(activity,"Berhasil logout", Toast.LENGTH_SHORT).show()
            startActivity(Intent(activity, WelcomeActivity::class.java))
        }
        return view
    }

    private fun init(view: View) {
        tvLogout = view.findViewById(R.id.tv_logout)

    }

}