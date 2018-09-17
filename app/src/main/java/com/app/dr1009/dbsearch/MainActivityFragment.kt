package com.app.dr1009.dbsearch

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.dr1009.dbsearch.databinding.FragmentMainBinding
import com.app.dr1009.dbsearch.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val adapter = WordListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        binding.words().observe(this, Observer { adapter::submitList })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)
        binding.adapter = adapter

        return binding.root
    }
}
