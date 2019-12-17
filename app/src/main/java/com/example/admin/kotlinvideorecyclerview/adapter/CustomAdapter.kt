package com.example.admin.kotlinvideorecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.admin.kotlinvideorecyclerview.R
import com.example.admin.kotlinvideorecyclerview.databinding.CategoryBinding
import com.example.admin.kotlinvideorecyclerview.viewmodel.CategoryViewModel

class CustomAdapter(private val context: Context, private val arrylist: ArrayList<CategoryViewModel>) : RecyclerView.Adapter<CustomAdapter.CustomView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val categoryBinding: CategoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.innerlayout, parent, false)
        return CustomView(categoryBinding)
    }

    override fun getItemCount(): Int {
        return arrylist.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        val categoryViewModel = arrylist[position]
        holder.bind(categoryViewModel)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, categoryViewModel.title, Toast.LENGTH_SHORT).show()
        }
    }

    class CustomView(val categoryBinding: CategoryBinding) : RecyclerView.ViewHolder(categoryBinding.root) {
        fun bind(categoryViewModel: CategoryViewModel) {
            this.categoryBinding.categorymodel = categoryViewModel
            categoryBinding.executePendingBindings()

        }

    }

}