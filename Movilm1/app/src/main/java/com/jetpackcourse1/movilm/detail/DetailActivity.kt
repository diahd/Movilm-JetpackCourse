package com.jetpackcourse1.movilm.detail

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.databinding.ActivityDetailFilmBinding
import com.jetpackcourse1.movilm.databinding.ContentDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ContentDetailBinding

    companion object {
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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val title = extras.getString(EXTRA_DETAIL)
            if(title != null){
                viewModel.setSelected(title)
                showData(viewModel.getFilm())
            }
        }
    }

    private fun showData(dataEntity: DataEntity) {
        detailBinding.progressBar.visibility = INVISIBLE

        detailBinding.apply {
            txtTitle.text = dataEntity.title
            txtRating.text = dataEntity.rating
            txtDate.text = dataEntity.date
            txtScore.text = dataEntity.score
            txtDuration.text = dataEntity.duration
            txtGenre.text = dataEntity.genre
            txtOverview.text = dataEntity.overview
            txtCreator.text = resources.getString(R.string.creator_director, dataEntity.director)
        }
        Glide.with(this)
            .load(dataEntity.poster)
            .centerCrop()
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(detailBinding.imgPoster)

        Glide.with(this)
            .load(dataEntity.poster)
            .apply(RequestOptions.bitmapTransform(jp.wasabeef.glide.transformations.BlurTransformation(10, 3)))
            .into(detailBinding.imgBgPoster)

        detailBinding.imgAdd.setOnClickListener{
            Toast.makeText(this, "Added to my list.", Toast.LENGTH_SHORT).show()
        }
        detailBinding.imgRate.setOnClickListener{
            Toast.makeText(this, "You like this.", Toast.LENGTH_SHORT).show()
        }
        detailBinding.imgShare.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Watch ${dataEntity.title}.")
            intent.type = "text/plain"
            startActivity(intent)
        }
    }
}