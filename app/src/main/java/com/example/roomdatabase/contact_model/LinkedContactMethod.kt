package com.example.roomdatabase.contact_model

data class LinkedContactMethod(
    val accountID: String,
    val callTransferFlowEnabled: Boolean,
    val contactID: String,
    val countryCode: String,
    val createdDate: Long,
    val deleted: Boolean,
    val deliveryMethodEnabled: Boolean,
    val departmentID: String,
    val extension: Any,
    val id: String,
    val isPrivate: Boolean,
    val isSMSCompatible: Boolean,
    val isValid: Boolean,
    val isVerified: Boolean,
    val locationID: Any,
    val nationalNumber: String,
    val onCallFlowEnabled: Boolean,
    val primary: Boolean,
    val specificPeopleCallFlowEnabled: Boolean,
    val subType: String,
    val title: String,
    val type: String,
    val typeID: String,
    val value: String
)