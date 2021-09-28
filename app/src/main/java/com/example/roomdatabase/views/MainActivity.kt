package com.example.roomdatabase.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.R
import com.example.roomdatabase.adapter.EntityAdapter
import com.example.roomdatabase.data.ContactEntity
import com.example.roomdatabase.data.EventEntity
import com.example.roomdatabase.viewmodel.MyViewModel
import com.example.roomdatabase.viewmodel.MyViewmodelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: EntityAdapter

    private lateinit var viewModel: MyViewModel
    var joinList = mutableListOf<JoinEntity>()

    private var eventList = mutableListOf<EventEntity>()

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

        viewModel.getContactResponse()
        viewModel.getEventResponse()


        tvItem.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                val event = viewModel.getEventEntity()
                eventList.addAll(event)
                joinList.clear()

                val contactList = HashMap<String, ContactEntity>()

                for (i in 0 until eventList.size) {

                    if (!contactList.containsKey(eventList[i].provider)) {

                        val data = viewModel.getContactEntity(eventList[i].provider!!)

                        contactList.put(eventList[i].provider!!, data)

                        val joinEntity = JoinEntity(data, eventList[i])
                        joinList.add(joinEntity)

                    }
                    else {

                        val data = contactList.get(eventList[i].provider)

                        val joinEntity = JoinEntity(data, eventList[i])
                        joinList.add(joinEntity)

                    }
                }
                CoroutineScope(Dispatchers.Main).launch {
                    adapter.notifyDataSetChanged()
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}