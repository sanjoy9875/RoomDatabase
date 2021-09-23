package com.example.roomdatabase.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: EntityAdapter

    private lateinit var viewModel : MyViewModel
    var joinList = mutableListOf<JoinEntity>()

   private var contactList = mutableListOf<ContactEntity>()
   private var eventList = mutableListOf<EventEntity>()

    private var contactSize = 0
    private var eventSize = 0

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

        viewModel.getContactEntity().observe(this, Observer {
            Log.d("main",it.toString())
            contactList.clear()
            contactList.addAll(it)
            setContactSize(contactList.size)
        })

        viewModel.getEventEntity().observe(this, Observer {
            Log.d("main",it.toString())
                eventList.clear()
                eventList.addAll(it)
            setEventSize(eventList.size)
        })

        tvItem.setOnClickListener {
            addList()
        }

    }
     fun setContactSize(contactSize : Int){
        this.contactSize = contactSize
    }
     fun setEventSize(eventSize : Int){
        this.eventSize = eventSize
    }

    fun addList(){
        if (eventSize>0 && contactSize>0) {
            joinList.clear()
            for (i in 0 until eventSize){
                for (j in 0 until contactSize){
                    if (eventList[i].brand==contactList[j].brandId){
                        val joinEntity = JoinEntity(
                            contactList[j].type,
                            contactList[j].firstName,
                            contactList[j].brandId,
                            eventList[i].type,
                            eventList[i].title,
                            eventList[i].brand,
                        )
                        joinList.add(joinEntity)
                        break

                    }

                }
            }
            Log.d("joinList",joinList.toString())
            adapter.notifyDataSetChanged()
        }
    }

}