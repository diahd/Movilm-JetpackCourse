package com.jetpackcourse1.movilm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jetpackcourse1.movilm.BuildConfig
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.databinding.ItemsMovietvBinding
import com.jetpackcourse1.movilm.detail.DetailActivity


class HomeAdapter: RecyclerView.Adapter<HomeAdapter.DataViewHolder>() {
    private var listData = ArrayList<DataEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setData(data: List<DataEntity>){
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemsMovietvBinding = ItemsMovietvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemsMovietvBinding)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listData[holder.adapterPosition])
        }
    }

    class DataViewHolder(private val binding: ItemsMovietvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEntity) {
            with(binding) {
                tvItemTitle.text = data.title
                //tvYear.text = data.year
                tvScore.text = data.score
                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                    itemView.context.startActivity(intent)
                    //onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
                }*/
                Glide.with(itemView.context)
                        .load(BuildConfig.BASE_IMG + data.poster)
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                        .error(R.drawable.ic_error)
                        )
//                        .centerCrop()
                        .centerInside()
                        .into(imgPoster)
            }
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: DataEntity)
    }
}