package com.app.dr1009.dbsearch

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dr1009.dbsearch.entity.Word

class WordListAdapter : ListAdapter<Word, WordListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bindTo(getItem(position))

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = DataBindingUtil.bind<ViewDataBinding>(view)

        fun bindTo(word: Word) {
            binding?.run {
                setVariable(BR.word, word)
                executePendingBindings()
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(p0: Word, p1: Word) = p0.id == p1.id
            override fun areContentsTheSame(p0: Word, p1: Word) = p0 == p1
        }
    }
}


