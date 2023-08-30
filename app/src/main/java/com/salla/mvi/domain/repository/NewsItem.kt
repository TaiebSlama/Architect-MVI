package com.salla.mvi.domain.repository

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 *
 */

data class NewsItem(
    val title: String,
    val description: String,
    val imageUrl: String
) {

    companion object {
        object NewsItemItemCallback : DiffUtil.ItemCallback<NewsItem>() {
            override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}
