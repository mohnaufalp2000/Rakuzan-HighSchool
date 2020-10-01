package com.gopal.rakuzanhighschool

import android.gesture.GestureLibraries
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Adapter(private val listAdapter : ArrayList<Rakuzan>) : RecyclerView.Adapter<Adapter.ListViewHolder>() {

    private lateinit var onItemClickCallBack : OnItemClickCallBack

    interface OnItemClickCallBack {
        fun onItemClicked(data : Rakuzan)
    }

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    inner class ListViewHolder(itemV : View) : RecyclerView.ViewHolder(itemV) {
        val title: TextView = itemV.findViewById(R.id.tv_title)
        val desc: TextView = itemV.findViewById(R.id.tv_desc)
        val img: ImageView = itemV.findViewById(R.id.iv_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listAdapter.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val bind : Rakuzan = listAdapter[position]

        Glide.with(holder.itemView.context)
            .load(bind.img)
            .apply(RequestOptions.centerCropTransform())
            .into(holder.img)

        holder.title.text = bind.title
        holder.desc.text = bind.desc

        holder.itemView.setOnClickListener{onItemClickCallBack.onItemClicked(listAdapter[holder.adapterPosition])}
    }
}