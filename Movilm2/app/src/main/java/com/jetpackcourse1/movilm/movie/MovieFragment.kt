package com.jetpackcourse1.movilm.movie

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
import com.jetpackcourse1.movilm.databinding.FragmentMovieBinding
import com.jetpackcourse1.movilm.detail.DetailActivity
import com.jetpackcourse1.movilm.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var adapter2: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter2 = HomeAdapter()
        adapter2.notifyDataSetChanged()

        fragmentMovieBinding.progressBar.visibility = View.VISIBLE

        val factory = ViewModelFactory.getInstance(requireActivity())
        val movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        movieViewModel.getMovies().observe(viewLifecycleOwner, {
            handleData(it)
        })
    }

    private fun handleData(movie: List<DataEntity>){
        fragmentMovieBinding.progressBar.visibility = INVISIBLE

        adapter2.setData(movie)
        fragmentMovieBinding.rvMovies.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = adapter2
        }

        adapter2.setOnItemClickCallback(object : HomeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataEntity) {
                val moveActivity = Intent(activity, DetailActivity::class.java)
                moveActivity.putExtra(DetailActivity.EXTRA_DETAIL, "MOVIE")
                moveActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
                startActivity(moveActivity)
            }
        })
    }
}