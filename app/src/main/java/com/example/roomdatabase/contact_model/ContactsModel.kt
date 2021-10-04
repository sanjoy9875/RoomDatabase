package com.example.roomdatabase.contact_model


data class ContactsModel(
    val contacts: List<Contact>? = null,
    val count: Int? = null,
    val cursor: String? = null,
    val success: Boolean? = null
)

