package com.architect.mvi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.architect.mvi.BR

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 */
open class GenericListAdapter<M>(
    private var layoutId: Int = 0,
    private var diffUtil: DiffUtil.ItemCallback<M>
) : ListAdapter<M, GenericListAdapter.MyViewHolder<M>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<M> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false) as ViewDataBinding
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder<M>, position: Int) {
        val model = getItem(position)
        holder.bind(model, position)
    }

    class MyViewHolder<M>(private var binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            model: M,
            position: Int
        ) {
            binding.setVariable(BR.model, model)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    open fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }

}