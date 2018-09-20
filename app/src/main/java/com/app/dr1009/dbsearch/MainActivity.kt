package com.app.dr1009.dbsearch

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.app.dr1009.dbsearch.databinding.ActivityMainBinding
import com.app.dr1009.dbsearch.di.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        val adapter = WordListAdapter()
        viewModel.words().observe(this, Observer(adapter::submitList))
        binding.include!!.recycler.adapter = adapter

        binding.fab.setOnClickListener {
            val dialog = AddWordDialog()
            dialog.show(supportFragmentManager, "dialog")
        }
    }
}
