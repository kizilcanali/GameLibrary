package com.alikizilcan.gamelib

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T: BindableItem>(@LayoutRes val layoutId: Int) : ListAdapter<T, GenericAdapter.GenericViewHolder<T>>(GenericCallback<T>()){
    class GenericViewHolder<T: BindableItem>(
        private val binding: ViewDataBinding,
        private val itemClickListener: (T) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        TODO("Not yet implemented")
    }

    class GenericCallback<T: BindableItem> : DiffUtil.ItemCallback<T>(){
        override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.toString() == newItem.toString()

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
    }

}