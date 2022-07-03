package com.dina.tentangfragment.activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dina.tentangfragment.R
import com.dina.tentangfragment.api.ApiConfig
import com.dina.tentangfragment.helper.SharedPreference
import kotlinx.android.synthetic.main.activity_daftar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarActivity : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        sharedPreference = SharedPreference(this)

        btn_daftar.setOnClickListener{
            daftar()
        }
    }

    private fun daftar () {
        val name = edt_name_regis.text.toString()
        val name = edt_email_regis.text.toString()
        val name = edt_phone_regis.text.toString()
        val name = edt_city_regis.text.toString()
        val name = edt_pass_regis.text.toString()

        if (name.isEmpty()){
            edt_name_regis.error = "Isi dulu namanya"
            return
        }
        if (name.isEmpty()){
            edt_email_regis.error = "Isi dulu namanya"
            return
        }
        if (name.isEmpty()){
            edt_phone_regis.error = "Isi dulu namanya"
            return
        }
        if (name.isEmpty()){
            edt_city_regis.error = "Isi dulu namanya"
            return
        }
        if (name.isEmpty()){
            edt_pass_regis.error = "Isi dulu namanya"
            return
        }

        pb_regis.visibility = View.VISIBLE

        ApiConfig.instanceRetrofit.regisYuk(name, email, phone, pass, city).enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                pb_regis.visibility = View.GONE

                val response = response.body()

                if (response != null){
                    if (response.status == 0){
                        Toast.makeText(this@DaftarActivity, response.message, Toast.LENGTH_SHORT).show()
                    }else{
                        sharedPreference.setStatusLogin(true)
                        startActivity(Intent(this@DaftarActivity, MainActivity::class.java))
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                pb_regis.visibility = View.GONE
                Toast.makeText(this@DaftarActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}