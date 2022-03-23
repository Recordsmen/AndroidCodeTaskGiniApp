package com.example

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidcodetaskginiapp.databinding.RecyclerviewItemBinding
import com.example.androidcodetaskginiapp.model.Hit

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    private var dataSet = listOf<Hit>()

    class ViewHolder private constructor(val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerviewItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.ivImage.load(dataSet[position].largeImageURL)
        Log.i("TAG",dataSet[position].largeImageURL)
        viewHolder.binding.tvComments.text = "Comments:" + dataSet[position].comments
        viewHolder.binding.tvLikes.text = "Likes:" + dataSet[position].likes
    }

    override fun getItemCount() = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList:List<Hit>){
        dataSet = newList
        notifyDataSetChanged()
    }
}

