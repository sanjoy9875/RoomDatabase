package com.example.roomdatabase.helper

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.roomdatabase.contact_model.LinkedContactMethod
import com.example.roomdatabase.contact_model.LinkedLocation
import com.example.roomdatabase.event_model.ChangedProperties
import com.example.roomdatabase.event_model.Location
import com.example.roomdatabase.event_model.Log
import com.example.roomdatabase.event_model.MetaData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ConverterHelper {

    @TypeConverter
    fun stringToListOfStrings(value: String): ArrayList<String> {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listOfStringsToString(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun listOfLinkedContactMethodToString(listOfVisits: List<LinkedContactMethod>): String {
        return Gson().toJson(listOfVisits).toString()
    }

    @TypeConverter
    fun stringToListOfLinkedContactMethod(value: String): List<LinkedContactMethod> {
        val listOfVisits = object : TypeToken<ArrayList<LinkedContactMethod>>() {}.type
        return Gson().fromJson(value, listOfVisits)
    }

    @TypeConverter
    fun listOfLinkedLocationToString(listOfVisits: List<LinkedLocation>): String {
        return Gson().toJson(listOfVisits).toString()
    }

    @TypeConverter
    fun stringToListOfLinkedLocation(value: String): List<LinkedLocation> {
        val listOfVisits = object : TypeToken<ArrayList<LinkedLocation>>() {}.type
        return Gson().fromJson(value, listOfVisits)
    }

    @TypeConverter
    fun fromStringToMetaData(value: String): MetaData? {
        return MetaData(value)
    }

    @TypeConverter
    fun fromMetaDataToString(metaData : MetaData?): String {
        return metaData?.bookingId.toString()
    }

    @TypeConverter
    fun fromStringToLocation(value: String): Location? {
        return Location(value)
    }

    @TypeConverter
    fun fromLocationToString(location : Location?): String {
        return location?.videoMeeting.toString()
    }

    @TypeConverter
    fun fromStringToLog(value: String): Log? {
        val listOfProperties = ChangedProperties()
        return Log(listOfProperties)
    }

    @TypeConverter
    fun fromLogToString(log : Log?): String {
        return log?.changedProperties.toString()
    }


}