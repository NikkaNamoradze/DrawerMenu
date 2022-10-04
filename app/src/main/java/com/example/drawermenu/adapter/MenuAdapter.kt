package com.example.drawermenu.adapter

import android.graphics.Color
import android.view.*
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.databinding.MenuItemBinding
import com.example.drawermenu.model.ModelItem

class MenuAdapter : ListAdapter<ModelItem, MenuAdapter.MenuItemViewHolder>(ItemDiffCallBack()) {

    var itemClick: ((ModelItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return MenuItemViewHolder(
            MenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class MenuItemViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val currentItem = getItem(adapterPosition)
            binding.apply {
                ivMenuIcon.setImageResource(currentItem.icon)
                tvMenuTitle.text = currentItem.title
                currentItem.badgeCount?.let {
                    tvBadge.text = it.toString()
                    tvBadge.background.setTint(currentItem.badgeColor!!)
                    tvBadge.visibility = View.VISIBLE
                }
                root.setOnClickListener { itemClick?.invoke(currentItem) }
            }
        }
    }

    class ItemDiffCallBack : ItemCallback<ModelItem>() {
        override fun areItemsTheSame(oldItem: ModelItem, newItem: ModelItem): Boolean {
            return oldItem.menuType == newItem.menuType
        }

        override fun areContentsTheSame(oldItem: ModelItem, newItem: ModelItem): Boolean {
            return oldItem == newItem
        }
    }


}