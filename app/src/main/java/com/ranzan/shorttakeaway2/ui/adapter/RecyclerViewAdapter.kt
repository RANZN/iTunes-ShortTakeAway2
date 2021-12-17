package com.ranzan.shorttakeaway2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.shorttakeaway2.R
import com.ranzan.shorttakeaway2.databinding.ItemLayoutBinding
import com.ranzan.shorttakeaway2.model.database.TheEntity

class RecyclerViewAdapter(var list: ArrayList<TheEntity>) :
    RecyclerView.Adapter<RecyclerViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutBinding: ItemLayoutBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_layout,
                parent,
                false
            )
        return RecyclerViewViewHolder(layoutBinding)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class RecyclerViewViewHolder(private val itemLayoutBinding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(itemLayoutBinding.root) {
    fun onBind(item: TheEntity) {
        itemLayoutBinding.item = item
    }

}