package com.example.khabarzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    val api = "caab743de05c4625b0fe67806625762c"

    lateinit var mtoolbar: Toolbar
    lateinit var pageAdapter: PageAdapter
    lateinit var tabLayout: TabLayout


    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mtoolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mtoolbar)

        val mhome = findViewById<TabItem>(R.id.myHome)
        val mhealth = findViewById<TabItem>(R.id.health)
        val mtech = findViewById<TabItem>(R.id.technology)
        val menter = findViewById<TabItem>(R.id.entertainment)
        val msports = findViewById<TabItem>(R.id.sport)
        val mscience = findViewById<TabItem>(R.id.science)

        viewPager = findViewById(R.id.fragment_container)
        tabLayout = findViewById(R.id.tab_include)

        pageAdapter = PageAdapter(supportFragmentManager, 6)
        viewPager.adapter = pageAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
                if (tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5) {
                    pageAdapter.notifyDataSetChanged()
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        viewPager.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(tabLayout){})


    }
}