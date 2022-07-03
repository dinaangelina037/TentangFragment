package com.dina.tentangfragment.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dina.tentangfragment.R
import com.dina.tentangfragment.fragment.AkunFragment
import com.dina.tentangfragment.fragment.BookmarkFragment
import com.dina.tentangfragment.fragment.HomeFragment
import com.dina.tentangfragment.helper.SharedPreference

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentBookmark: Fragment = BookmarkFragment()
    val fragmentAkun: Fragment = AkunFragment()
    val fragmentManager: FragmentManager = supportFragmentManager
    var active : Fragment = fragmentHome

    lateinit var menu: Menu
    lateinit var menuItem: MenuItem
    lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var sharedPreference: SharedPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreference = SharedPreference(this)
        setUpBottomNavigations()


    }

    private fun setUpBottomNavigations() {
        fragmentManager.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fragmentManager.beginTransaction().add(R.id.container, fragmentBookmark).hide(fragmentBookmark).commit()
        fragmentManager.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { it ->


//        untuk melihat data di logcat
            when(it.itemId){
                R.id.navigation_home ->{
                    Log.d("Response", "Home")
                        callFragment(0 ,fragmentHome)
                }

                R.id.navigation_bookmark ->{
                    Log.d("Response", "Bookmark")
                    callFragment(2 ,fragmentBookmark)
                }

                R.id.navigation_akun ->{
                    Log.d("Response", "Akun")
                    callFragment(1 ,fragmentAkun)
                    if (sharedPreference.getStatusLogin()){

                    }else{
                        startActivity(Intent(this, WelcomeActivity::class.java))
                    }
                }
            }

            false

        }

    }

    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fragmentManager.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }
}


