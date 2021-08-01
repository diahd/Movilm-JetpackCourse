package com.jetpackcourse1.movilm.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpackcourse1.movilm.adapter.HomeAdapter
import com.jetpackcourse1.movilm.databinding.FragmentTVShowBinding

class TVShowFragment : Fragment() {

    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTVShowBinding.progressBar.visibility = View.VISIBLE

        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVShowViewModel::class.java]
            val data = viewModel.getTVShow()

            val tvshowadapter = HomeAdapter()
            tvshowadapter.setData(data)

            with(fragmentTVShowBinding.rvTvshows) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvshowadapter
                fragmentTVShowBinding.progressBar.visibility = View.INVISIBLE
            }
        }
    }
}