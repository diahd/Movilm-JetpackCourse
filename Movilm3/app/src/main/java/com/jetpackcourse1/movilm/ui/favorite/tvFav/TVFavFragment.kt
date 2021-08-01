package com.jetpackcourse1.movilm.ui.favorite.tvFav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.databinding.FragmentTVFavBinding
import com.jetpackcourse1.movilm.ui.detail.DetailActivity
import com.jetpackcourse1.movilm.ui.favorite.FavoriteViewModel
import com.jetpackcourse1.movilm.ui.home.tvshow.TVShowAdapter
import com.jetpackcourse1.movilm.viewmodel.ViewModelFactory

class TVFavFragment : Fragment() {

    private lateinit var binding: FragmentTVFavBinding
    private lateinit var adapterTv: TVShowAdapter
    private lateinit var viewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTVFavBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding.rvFavTv)

        adapterTv = TVShowAdapter()

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        viewModel.getFavTV().observe(viewLifecycleOwner, { tvFav ->
            adapterTv.submitList(tvFav)
            adapterTv.notifyDataSetChanged()

            binding.rvFavTv.apply {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = adapterTv
            }

            adapterTv.setOnItemClickCallback(object : TVShowAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TVShowEntity) {
                    val moveActivity = Intent(activity, DetailActivity::class.java)
                    moveActivity.putExtra(DetailActivity.EXTRA_DETAIL, "TVShow")
                    moveActivity.putExtra(DetailActivity.EXTRA_ID, data.id)
                    startActivity(moveActivity)
                }
            })
        })
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvEntity = adapterTv.getSwipedData(swipedPosition)
                tvEntity?.let { viewModel.setFavTV(tvEntity, it.isFavorite) }
                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    tvEntity?.let { viewModel.setFavTV(tvEntity, it.isFavorite) }
                }
                snackbar.show()
            }
        }
    })
}