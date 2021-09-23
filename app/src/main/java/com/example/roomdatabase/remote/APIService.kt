package com.example.roomdatabase.remote

import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.event_model.Data
import com.example.roomdatabase.event_model.EventsModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface APIService {

    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getContacts(
        @Header("Content-Type") contentType: String,
    ):ContactsModel


    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getEvents(
        @Header("Content-Type") contentType: String,
    ): EventsModel

}