package com.app.dr1009.dbsearch

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dr1009.dbsearch.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WordListAdapter()
        view.findViewById<RecyclerView>(R.id.recycler).adapter = adapter

        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.words().observe(this, Observer(adapter::submitList))
    }
}
