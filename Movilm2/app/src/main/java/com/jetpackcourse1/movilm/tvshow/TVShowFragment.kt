package com.jetpackcourse1.movilm.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpackcourse1.movilm.adapter.HomeAdapter
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.databinding.FragmentTVShowBinding
import com.jetpackcourse1.movilm.detail.DetailActivity
import com.jetpackcourse1.movilm.viewmodel.ViewModelFactory

class TVShowFragment : Fragment() {

    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding
    private lateinit var adapterTv: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterTv = HomeAdapter()
        adapterTv.notifyDataSetChanged()

        fragmentTVShowBinding.progressBar.visibility = View.VISIBLE

        val factory = ViewModelFactory.getInstance(requireActivity())
        val movieViewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]

        movieViewModel.getTv().observe(viewLifecycleOwner, {
            handleData(it)
        })

        adapterTv.setOnItemClickCallback(object : HomeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataEntity) {
                val moveActivity = Intent(activity, DetailActivity::class.java)
                moveActivity.putExtra(DetailActivity.EXTRA_DETAIL, "TVShow")
                moveActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
                startActivity(moveActivity)
            }
        })
    }

    private fun handleData(TV: List<DataEntity>) {
        fragmentTVShowBinding.progressBar.visibility = INVISIBLE

        adapterTv.setData(TV)
        fragmentTVShowBinding.rvTvshows.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = adapterTv
        }
    }
}