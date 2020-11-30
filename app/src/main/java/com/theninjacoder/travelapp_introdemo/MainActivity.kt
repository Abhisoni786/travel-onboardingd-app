package com.theninjacoder.travelapp_introdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var nextButton: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init the views
        tabLayout = findViewById(R.id.dots)
        pager = findViewById(R.id.intro_pager)
        nextButton = findViewById(R.id.next_btn)


        //create object of adapter
        val adapter = IntroAdapter()
        //Create a Item List
        val itemList = mutableListOf(
                ScreenItems(1, "Connect with tourists", getString(R.string.item_content_1), R.drawable.trip_amico),
                ScreenItems(2, "Discover new things", "Explore new things through our app.Discover initially and other stuff", R.drawable.exploring_amico),
                ScreenItems(3, "Share your moments", "Share your trip initially with others .", R.drawable.sharing_ideas_amico),
        )
        //submit the list to adapter
        adapter.submitList(itemList)
        //attach the adapter to ViewPager2
        pager.adapter = adapter

        //attach the tabLayout to viewPager2
        TabLayoutMediator(tabLayout, pager) { _, _ -> }.attach()


        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == itemList.size) {
                    nextButton.icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_check, theme)
                } else
                    nextButton.icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow, theme)
                super.onPageSelected(position)
            }
        })

        nextButton.setOnClickListener {
            if ((getItemPosition(+1)) > pager.childCount - 1) {
                Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show()
            } else {
                pager.setCurrentItem(getItemPosition(-1), true)
            }
        }

    }

    private fun getItemPosition(i: Int) =
            pager.currentItem + i
}