package com.alikizilcan.gamelib.ui.list.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alikizilcan.gamelib.databinding.PagerItemBinding
import com.alikizilcan.gamelib.domain.model.Game

class ListViewPagerAdapter() : ListAdapter<Game, ListViewPagerAdapter.GameViewHolder>(DIFF_CALLBACK){

    var itemClickListener: (Game) -> Unit = {}

    class GameViewHolder(private val binding: PagerItemBinding, private val itemClickListener: (Game) -> Unit) : RecyclerView.ViewHolder(binding.root){
        fun bind(game : Game){
            binding.baseModel = game
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                itemClickListener(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = PagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem == newItem

        }
    }

}