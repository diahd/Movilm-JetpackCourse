package com.jetpackcourse1.movilm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.databinding.ItemsMovietvBinding
import com.jetpackcourse1.movilm.detail.DetailActivity

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.DataViewHolder>() {
    private var listData = ArrayList<DataEntity>()

    fun setData(data: List<DataEntity>?){
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemsMovietvBinding = ItemsMovietvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemsMovietvBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    class DataViewHolder(private val binding: ItemsMovietvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEntity) {
            with(binding) {
                tvItemTitle.text = data.title
                tvYear.text = data.year
                tvScore.text = data.score
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, data.title)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(data.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .centerCrop()
                    .into(imgPoster)

            }
        }
    }
}