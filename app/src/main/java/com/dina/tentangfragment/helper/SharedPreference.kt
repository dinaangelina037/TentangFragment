package com.dina.tentangfragment.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreference(activity: Activity) {

    val login = "Login"
    val user = "User"
    val myPref = "MyPref"

    val sharedPreference: SharedPreferences

    init {
        sharedPreference = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status : Boolean){
        sharedPreference.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin() : Boolean{
        return sharedPreference.getBoolean(login, false)
    }

}
