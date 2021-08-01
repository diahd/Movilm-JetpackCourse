package com.jetpackcourse1.movilm.detail

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jetpackcourse1.movilm.BuildConfig
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.databinding.ActivityDetailFilmBinding
import com.jetpackcourse1.movilm.databinding.ContentDetailBinding
import com.jetpackcourse1.movilm.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ContentDetailBinding

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailBinding = activityDetailBinding.detailContent

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailBinding.progressBar.visibility = VISIBLE

        val idextra = intent.getIntExtra(EXTRA_ID, 0)
        val typextra = intent.getStringExtra(EXTRA_DETAIL)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        if (typextra == "MOVIE") {
            viewModel.getMovieDetail(idextra).observe(this, {
                showData(it)
            })
            viewModel.getMovieGenre(idextra).observe(this,{ listDataGenre->
                val listGenre = listDataGenre.map { dataGenre ->
                    "${dataGenre.name} "
                }
                detailBinding.lvGenre.adapter =
                    ArrayAdapter(this, R.layout.items_genre, listGenre)
            })
        } else {
            viewModel.getTvDetail(idextra).observe(this, {
                showData(it)
            })
            viewModel.getTVGenre(idextra).observe(this,{
                val listGenre = it.map { dataGenre ->
                    "${dataGenre.name} "
                }
                detailBinding.lvGenre.adapter =
                    ArrayAdapter(this, R.layout.items_genre, listGenre)
            })
        }

        detailBinding.imgAdd.setOnClickListener {
            Toast.makeText(this, "Added to my list.", Toast.LENGTH_SHORT).show()
        }
        detailBinding.imgRate.setOnClickListener {
            Toast.makeText(this, "You like this.", Toast.LENGTH_SHORT).show()
        }
        detailBinding.imgShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Watch \"${detailBinding.txtTitle.text}.\"")
            intent.type = "text/plain"
            startActivity(intent)
        }
    }

    private fun showData(dataEntity: DataEntity) {
        detailBinding.progressBar.visibility = INVISIBLE

        detailBinding.apply {
            txtTitle.text = dataEntity.title
            txtDate.text = resources.getString(R.string.date_release, dataEntity.date)
            ratingBar.rating = (dataEntity.score?.toFloat() as Float) /2
            txtScore.text = resources.getString(R.string.score, dataEntity.score.toString())
            txtOverview.text = dataEntity.overview
        }
        Glide.with(this)
            .load(BuildConfig.BASE_IMG + dataEntity.poster)
            .centerCrop()
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(detailBinding.imgPoster)

        Glide.with(this)
            .load(BuildConfig.BASE_IMG + dataEntity.poster)
            .apply(RequestOptions.bitmapTransform(jp.wasabeef.glide.transformations.BlurTransformation(10, 3)))
            .into(detailBinding.imgBgPoster)

    }
}
