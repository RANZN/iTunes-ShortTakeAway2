package com.ranzan.shorttakeaway2.ui

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranzan.shorttakeaway2.R
import com.ranzan.shorttakeaway2.databinding.ActivityMainBinding
import com.ranzan.shorttakeaway2.model.Repo
import com.ranzan.shorttakeaway2.model.database.TheDao
import com.ranzan.shorttakeaway2.model.database.TheDatabase
import com.ranzan.shorttakeaway2.model.database.TheEntity
import com.ranzan.shorttakeaway2.ui.adapter.RecyclerViewAdapter
import com.ranzan.shorttakeaway2.viewmodel.TheViewModel
import com.ranzan.shorttakeaway2.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: TheViewModel
    var list = ArrayList<TheEntity>()

    //Defining room as context need to pass to initialize it.
    private lateinit var roomDatabase: TheDatabase
    private lateinit var theDao: TheDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //assigning roomDB
        roomDatabase = TheDatabase.getDatabaseObject(this)
        theDao = roomDatabase.getDao()
        val repo = Repo(theDao)

        //defining viewModel
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(TheViewModel::class.java)


        activityMainBinding.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchData(p0)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                searchData(p0)
                return false
            }

        })

    }

    private fun searchData(p0: String?) {
        viewModel.getDataFromApi(p0!!).observe(this, Observer {
            list = it as ArrayList<TheEntity>
            setRecyclerView(list)
        })
    }

    private fun setRecyclerView(list: java.util.ArrayList<TheEntity>) {
        activityMainBinding.recyclerView.apply {
            adapter = RecyclerViewAdapter(list)
//            layoutManager = GridLayoutManager(this@MainActivity, 2)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


}