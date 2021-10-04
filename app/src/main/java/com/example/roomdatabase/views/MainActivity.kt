package com.example.roomdatabase.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.R
import com.example.roomdatabase.adapter.EntityAdapter
import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.event_model.Event
import com.example.roomdatabase.viewmodel.MyViewModel
import com.example.roomdatabase.viewmodel.MyViewmodelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: EntityAdapter

    private lateinit var viewModel: MyViewModel
    var joinList = mutableListOf<JoinEntity>()

    var contactLists = mutableListOf<Contact>()
    var eventLists = mutableListOf<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * pass a empty-list to the adapter
         **/
        adapter = EntityAdapter(joinList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        /**
         * creating a view-model object to access the methods of view-model
         **/
        val appObj = application as MyApplication

        val repository = appObj.repository
        val viewModelFactory = MyViewmodelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MyViewModel::class.java)

        viewModel.getContactResponse().observe(this, Observer {
            contactLists.addAll(it.contacts!!)
            viewModel.insertContactListIntoDatabase(contactLists)
        })

        viewModel.getEventResponse().observe(this, Observer {
           eventLists.addAll(it.data?.events!!)
            viewModel.insertEventListIntoDatabase(eventLists)
        })


        tvItem.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            viewModel.mergeContactAndEventById().observe(this, Observer {
                joinList.clear()
                joinList.addAll(it)
                adapter.notifyDataSetChanged()
               progressBar.visibility = View.GONE
            })

        }
    }
}