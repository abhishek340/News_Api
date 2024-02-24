package com.example.newsapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.newsapi.databinding.ItemLayoutBinding
import com.example.newsapi.models.Article

class DemoAdapter(private val context: Context,private val items : List<Article>): RecyclerView.Adapter<DemoAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val intent = Intent(context,WebViewActivity::class.java)
          //  val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", item.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article) {
            binding.item = item

            Glide.with(binding.root.context)
                .load(item.urlToImage)
                .into(binding.imgImage)

            binding.executePendingBindings()
        }
    }

}