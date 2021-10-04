package com.example.roomdatabase.contact_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_entity")
data class Contact(

    @ColumnInfo(name = "accountID")
    val accountID: String? = null,

    @ColumnInfo(name = "accountNumber")
    val accountNumber: String? = null,

    @ColumnInfo(name = "aliasName")
    val aliasName: String? = null,

    @ColumnInfo(name = "appID")
    val appID: String? = null,

    @ColumnInfo(name = "blocked")
    val blocked: Boolean? = null,

    @ColumnInfo(name = "brandID")
    val brandID: String? = null,

    @ColumnInfo(name = "callTransferFlowEnabled")
    val callTransferFlowEnabled: Boolean? = null,

    @ColumnInfo(name = "category")
    val category: String? = null,

    @ColumnInfo(name = "comments")
    val comments: String? = null,

    @ColumnInfo(name = "convertedAt")
    val convertedAt: String? = null,

    @ColumnInfo(name = "convertedBy")
    val convertedBy: String? = null,

    @ColumnInfo(name = "createdDate")
    val createdDate: Long? = null,

    @ColumnInfo(name = "current_terms_version")
    val current_terms_version: String? = null,

    @ColumnInfo(name = "deleted")
    val deleted: Boolean? = null,

    @ColumnInfo(name = "department")
    val department: String?= null,

    @ColumnInfo(name = "departmentID")
    val departmentID: String? = null,

    @ColumnInfo(name = "firstName")
    val firstName: String? = null,

    @ColumnInfo(name = "fullName")
    val fullName: String? = null,

    @ColumnInfo(name = "gender")
    val gender: String? = null,

    @ColumnInfo(name = "globallyShared")
    val globallyShared: Boolean? = null,

    @ColumnInfo(name = "id")
    val id: String? = null,

    @ColumnInfo(name = "incomingCallCount")
    val incomingCallCount: Int? = null,

    @ColumnInfo(name = "ipaddress")
    val ipaddress: String? = null,

    @ColumnInfo(name = "isALead")
    val isALead: Boolean? = null,

    @ColumnInfo(name = "isAnUser")
    val isAnUser: Boolean? = null,

    @ColumnInfo(name = "isVerified")
    val isVerified: Boolean? = null,

    @ColumnInfo(name = "is_password_present")
    val is_password_present: Boolean? = null,

    @ColumnInfo(name = "lastName")
    val lastName: String? = null,

    @ColumnInfo(name = "lastUpdatedDate")
    val lastUpdatedDate: Long? = null,

    @ColumnInfo(name = "linkedAccounts")
    val linkedAccounts: List<String>? = null,

    @ColumnInfo(name = "linkedContactMethods")
    val linkedContactMethods: List<LinkedContactMethod>? = null,

    @ColumnInfo(name = "linkedContacts")
    val linkedContacts: List<String>? = null,

    @ColumnInfo(name = "linkedCustomFields")
    val linkedCustomFields: List<String>? = null,

    @ColumnInfo(name = "linkedDeals")
    val linkedDeals: List<String>? = null,

    @ColumnInfo(name = "linkedDocuments")
    val linkedDocuments: List<String>? = null,

    @ColumnInfo(name = "linkedLocations")
    val linkedLocations: List<LinkedLocation>? = null,

    @ColumnInfo(name = "linkedProducts")
    val linkedProducts: List<String>? = null,

    @ColumnInfo(name = "linkedTags")
    val linkedTags: List<String>? = null,

    @ColumnInfo(name = "linkedTasks")
    val linkedTasks: List<String>? = null,

    @ColumnInfo(name = "login")
    val login: String? = null,

    @ColumnInfo(name = "mergedContactID")
    val mergedContactID: List<String>? = null,

    @ColumnInfo(name = "middleName")
    val middleName: String? = null,

    @ColumnInfo(name = "onCallFlowEnabled")
    val onCallFlowEnabled: Boolean? = null,

    @ColumnInfo(name = "ownerID")
    val ownerID: String? = null,

    @ColumnInfo(name = "password")
    val password: String? = null,

    @ColumnInfo(name = "photoID")
    val photoID: String? = null,

    @ColumnInfo(name = "primary")
    val primary: Boolean? = null,

    @ColumnInfo(name = "profileURL")
    val profileURL: String? = null,

    @ColumnInfo(name = "rating")
    val rating: Int? = null,

    @ColumnInfo(name = "salutation")
    val salutation: String? = null,

    @ColumnInfo(name = "sharedWith")
    val sharedWith: List<String>? = null,

    @ColumnInfo(name = "source")
    val source: String? = null,

    @ColumnInfo(name = "specificPeopleCallFlowEnabled")
    val specificPeopleCallFlowEnabled: Boolean? = null,

    @ColumnInfo(name = "ssn")
    val ssn: String? = null,

    @ColumnInfo(name = "stage")
    val stage: String? = null,

    @ColumnInfo(name = "subBrandID")
    val subBrandID: String? = null,

    @ColumnInfo(name = "subStage")
    val subStage: String? = null,

    @ColumnInfo(name = "subscriptions")
    val subscriptions: List<String>? = null,

    @ColumnInfo(name = "timeZone")
    val timeZone: String? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "type")
    val type: String? = null,

    @ColumnInfo(name = "verifiedSource")
    val verifiedSource: String? = null
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cId") var cId:Int? = null
}