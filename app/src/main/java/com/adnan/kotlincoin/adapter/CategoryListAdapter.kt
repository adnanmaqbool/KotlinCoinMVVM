package com.adnan.kotlincoin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adnan.kotlincoin.databinding.HomeItemBinding
import com.adnan.kotlincoin.interfaces.AdapterItemClick
import com.adnan.kotlincoin.model.responseModel.CategoryItem


class CategoryListAdapter(
    private val list: List<CategoryItem>,
    private val itemClick: AdapterItemClick
) :
    RecyclerView.Adapter<CategoryListAdapter.AccountsVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeItemBinding.inflate(layoutInflater, parent, false)
        return AccountsVH(binding)
    }

    override fun onBindViewHolder(holder: AccountsVH, position: Int) {
        holder.bind(list[position])

        holder.binding.lyModule.setOnClickListener {
            itemClick.onItemClick(list[position], position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class AccountsVH(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryItem) {
            binding.tvTitle.text = "Category Id= #".plus(item.Id)
            binding.tvDescription.text = "Total recipes = ".plus(item.RecipeCount)
        }
    }

}