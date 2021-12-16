package com.ranzan.shorttakeaway2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ranzan.shorttakeaway2.R
import com.ranzan.shorttakeaway2.databinding.ActivityMainBinding
import com.ranzan.shorttakeaway2.model.Repo
import com.ranzan.shorttakeaway2.viewmodel.TheViewModel
import com.ranzan.shorttakeaway2.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: TheViewModel
    var repo: Repo = Repo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(TheViewModel::class.java)
    }
}