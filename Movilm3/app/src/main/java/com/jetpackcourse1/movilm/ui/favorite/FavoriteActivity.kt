package com.jetpackcourse1.movilm.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jetpackcourse1.movilm.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapterFav(this, supportFragmentManager)
        activityFavoriteBinding.viewPagerFav.adapter = sectionsPagerAdapter
        activityFavoriteBinding.tabsFav.setupWithViewPager(activityFavoriteBinding.viewPagerFav)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Favorite"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}