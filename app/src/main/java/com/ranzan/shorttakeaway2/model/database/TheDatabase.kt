package com.ranzan.shorttakeaway2.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TheEntity::class], version = 1)
 abstract class TheDatabase : RoomDatabase() {
    abstract fun getDao(): TheDao

    companion object {
        private var INSTANCE: TheDatabase? = null

        fun getDatabaseObject(context: Context): TheDatabase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TheDatabase::class.java,
                    "database"
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