package com.example.roomdatabase.contact_model

data class ContactsModel(
    val contacts: List<Contact>,
    val count: Int,
    val cursor: String,
    val success: Boolean
)