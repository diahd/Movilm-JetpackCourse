package com.jetpackcourse1.movilm.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.ui.favorite.movieFav.MovieFavFragment
import com.jetpackcourse1.movilm.ui.favorite.tvFav.TVFavFragment

class SectionsPagerAdapterFav(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvshow)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFavFragment()
            1 -> TVFavFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size
}