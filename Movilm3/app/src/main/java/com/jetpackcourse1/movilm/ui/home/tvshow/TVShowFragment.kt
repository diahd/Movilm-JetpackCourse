package com.jetpackcourse1.movilm.ui.home.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.databinding.FragmentTVShowBinding
import com.jetpackcourse1.movilm.ui.detail.DetailActivity
import com.jetpackcourse1.movilm.viewmodel.ViewModelFactory
import com.jetpackcourse1.movilm.vo.Status

class TVShowFragment : Fragment() {

    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding
    private lateinit var adapterTv: TVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterTv = TVShowAdapter()
        adapterTv.notifyDataSetChanged()
        handleData()

        fragmentTVShowBinding.progressBar.visibility = View.VISIBLE

        val factory = ViewModelFactory.getInstance(requireActivity())
        val movieViewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]

        movieViewModel.getTv().observe(viewLifecycleOwner, { tv->
            if (tv != null) {
                when (tv.status) {
                    Status.LOADING -> fragmentTVShowBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentTVShowBinding.progressBar.visibility = View.GONE
                        adapterTv.submitList(tv.data)
                        adapterTv.notifyDataSetChanged()

                    }
                    Status.ERROR -> {
                        fragmentTVShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        adapterTv.setOnItemClickCallback(object : TVShowAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TVShowEntity) {
                val moveActivity = Intent(activity, DetailActivity::class.java)
                moveActivity.putExtra(DetailActivity.EXTRA_DETAIL, "TVShow")
                moveActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
                startActivity(moveActivity)
            }
        })
    }

    private fun handleData() {
        fragmentTVShowBinding.rvTvshows.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = adapterTv
        }
    }
}