package com.dina.tentangfragment.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dina.tentangfragment.R
import com.dina.tentangfragment.api.ApiConfig
import com.dina.tentangfragment.helper.SharedPreference
import com.dina.tentangfragment.model.ResponseUser
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreference = SharedPreference(this)

        btn_masuk.setOnClickListener {
            masukYuk()
        }
    }

    private fun masukYuk() {
        val email = edt_email.text.toString()
        val pass = edt_pass.text.toString()

        if (email.isEmpty()){
            edt_email.error = "isi woi"
            return
        }
        if (pass.isEmpty()) {
            edt_pass.error = "isi woi"
            return
        }

        pb.visibility = View.VISIBLE

        ApiConfig.instanceRetrofit.loginYuk(email,pass).enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                pb.visibility = View.GONE

                val response = response.body()

                if (response !=null){
                    if (response.status == 0){
                        Toast.makeText(this@LoginActivity, response.message, Toast.LENGTH_SHORT).show()
                    }else{
                        sharedPreference.setStatusLogin(true)
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                }
            }


            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}