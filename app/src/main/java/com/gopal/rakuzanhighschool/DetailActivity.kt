package com.gopal.rakuzanhighschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val TITLE = "title"
        const val DESC = "desc"
        const val IMAGE = "image"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra(TITLE)
        val desc = intent.getStringExtra(DESC)
        val img = intent.getIntExtra(IMAGE, 0)

            Glide.with(this)
                .load(img)
                .apply(RequestOptions.centerCropTransform())
                .into(tv_detail_img)

        tv_detail_name.text = title
        tv_detail_desc.text = desc


    }
}