package com.jetpackcourse1.movilm.ui.home.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jetpackcourse1.movilm.BuildConfig
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.databinding.ItemsMovietvBinding

class TVShowAdapter: PagedListAdapter<TVShowEntity, TVShowAdapter.DataViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowEntity>() {
            override fun areItemsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem.tvId == newItem.tvId
            }
            override fun areContentsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun getSwipedData(swipedPosition: Int): TVShowEntity? = getItem(swipedPosition)

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemsMovietvBinding = ItemsMovietvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemsMovietvBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data!!)
        }
    }

    class DataViewHolder(private val binding: ItemsMovietvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TVShowEntity) {
            with(binding) {
                tvItemTitle.text = data.title
                tvScore.text = data.score
                Glide.with(itemView.context)
                    .load(BuildConfig.BASE_IMG + data.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .centerInside()
                    .into(imgPoster)
            }
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: TVShowEntity)
    }
}