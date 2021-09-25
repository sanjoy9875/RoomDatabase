package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EventEntity::class], version = 1)
abstract class EventDatabase : RoomDatabase() {

    abstract fun getEventDao(): EventDAO

    companion object {

        private var INSTANCE: EventDatabase? = null

        /**
         * Creating a Database called entity_database
         * */
        fun getRoomDatabase(context: Context): EventDatabase {

            if (INSTANCE == null) {

                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    EventDatabase::class.java,
                    "event_database"
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