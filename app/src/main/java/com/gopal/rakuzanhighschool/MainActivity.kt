package com.gopal.rakuzanhighschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listMainActivity : ArrayList<Rakuzan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_rakuzan.setHasFixedSize(true)

        listMainActivity.apply {
            clear()
            addAll(RakuzanData.listData)
        }

        showList()

    }
    

    private fun showList() {
        rv_rakuzan.layoutManager = LinearLayoutManager(this)
        val listAdapter = Adapter(listMainActivity)
        rv_rakuzan.adapter = listAdapter

        listAdapter.setOnItemClickCallBack(object : Adapter.OnItemClickCallBack{
            override fun onItemClicked(data: Rakuzan) {
                showSelected(data)
            }
        })
    }

    private fun showSelected(rakuzan: Rakuzan) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
            putExtra(DetailActivity.TITLE, rakuzan.title)
            putExtra(DetailActivity.DESC, rakuzan.desc)
            putExtra(DetailActivity.IMAGE, rakuzan.img)
        }
        startActivity(intent)
    }
}