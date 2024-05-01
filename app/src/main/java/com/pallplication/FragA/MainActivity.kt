package com.pallplication.FragA


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pallplication.FragA.ViewGroup.MainFragment


//fragment retrofit + okhttp + coroutine


open class MainActivity : AppCompatActivity() {

    private val fragSupport = supportFragmentManager
    private var mainFragmentFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hub_layout)
        val mainFragment = MainFragment().also {
            mainFragmentFlag = true
        }
        fragSupport.beginTransaction()
            .replace(R.id.mainFrameLayout,mainFragment)
            .commit()


    }

}