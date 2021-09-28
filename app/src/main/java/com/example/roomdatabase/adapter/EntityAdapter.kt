package com.example.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.R

class EntityAdapter(private var entity: List<JoinEntity>) :
    RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {

        holder.contactType.text = entity[position].contactEntity?.type
        holder.firstName.text = entity[position].contactEntity?.firstName
        holder.providerId.text = entity[position].eventEntity?.provider
        holder.eventType.text = entity[position].eventEntity?.type
        holder.eventTitle.text = entity[position].eventEntity?.title

        }

    override fun getItemCount(): Int {
        return entity.size
    }

    class EntityViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val contactType: TextView = view.findViewById(R.id.tvContactTypeText)
        val firstName: TextView = view.findViewById(R.id.tvFirstNameText)
        val providerId: TextView = view.findViewById(R.id.tvProviderIdText)
        val eventType: TextView = view.findViewById(R.id.tvEventTypeText)
        val eventTitle: TextView = view.findViewById(R.id.tvEventTitleText)

    }
}