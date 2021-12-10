package com.alikizilcan.gamelib.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alikizilcan.gamelib.databinding.ListGameItemBinding
import com.alikizilcan.gamelib.domain.model.Game

class GamesListAdapter : ListAdapter<Game, GamesListAdapter.GameHolder>(DIFF_CALLBACK) {

    var itemClickListener: (Game) -> Unit = {}

    class GameHolder(private val binding : ListGameItemBinding, private val itemClickListener: (Game) -> Unit) : RecyclerView.ViewHolder(binding.root){
        fun bind(game: Game){
            binding.baseModel = game
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                itemClickListener(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val binding = ListGameItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GameHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean = oldItem == newItem

        }
    }
}