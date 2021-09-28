package com.example.roomdatabase.contact_model

data class LinkedContactMethod(
    val accountID: String? = null,
    val callTransferFlowEnabled: Boolean? = null,
    val contactID: String? = null,
    val countryCode: String? = null,
    val createdDate: Long? = null,
    val deleted: Boolean? = null,
    val deliveryMethodEnabled: Boolean? = null,
    val departmentID: String? = null,
    val extension: Any? = null,
    val id: String? = null,
    val isPrivate: Boolean? = null,
    val isSMSCompatible: Boolean? = null,
    val isValid: Boolean? = null,
    val isVerified: Boolean? = null,
    val locationID: Any? = null,
    val nationalNumber: String? = null,
    val onCallFlowEnabled: Boolean? = null,
    val primary: Boolean? = null,
    val specificPeopleCallFlowEnabled: Boolean? = null,
    val subType: String? = null,
    val title: String? = null,
    val type: String? = null,
    val typeID: String? = null,
    val value: String? = null
)