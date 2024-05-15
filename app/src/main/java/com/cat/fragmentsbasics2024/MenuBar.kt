package com.cat.fragmentsbasics2024

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val Frag1 = FirstFragment()
private  val Frag2 = SecondFragment()
class MenuBar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_bar2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFrag(Frag1)
        val bottomBar = findViewById<BottomNavigationView>(R.id.NavBar)
        bottomBar.setOnItemSelectedListener{
            when (it.itemId)
            {
                R.id.ic_home->replaceFrag(Frag1)
                R.id.ic_settings->replaceFrag(Frag2)
            }
            true
        }

    }
    private fun replaceFrag(fragment: Fragment)
    {
        if(fragment!=null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout,fragment)
            transaction.commit()
        }
    }
}