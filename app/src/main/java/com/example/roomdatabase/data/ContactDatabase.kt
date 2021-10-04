package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.helper.ConverterHelper


@Database(entities = [Contact::class], version = 1)
@TypeConverters(ConverterHelper::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao(): ContactDAO

    companion object {

        private var INSTANCE: ContactDatabase? = null

        /**
         * Creating a Database called entity_database
         **/
        fun getRoomDatabase(context: Context): ContactDatabase {

            if (INSTANCE == null) {

                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contact_database"
                )

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }

        }

    }
}