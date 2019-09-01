package com.dr1009.app.dbsearch

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dr1009.app.dbsearch.databinding.ActivityMainBinding
import com.dr1009.app.dbsearch.di.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = WordListAdapter()
        viewModel.words().observe(this, Observer(adapter::submitList))
        binding.include.recycler.adapter = adapter

        binding.fab.setOnClickListener {
            val dialog = AddWordDialog()
            dialog.show(supportFragmentManager, "dialog")
        }
    }
}
