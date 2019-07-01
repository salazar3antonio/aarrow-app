package com.example.aarrowapp.data.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class, Audit::class], version = 1)
abstract class AArrowRoomDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile
        private var INSTANCE: AArrowRoomDatabase? = null

        fun getDatabase(context: Context): AArrowRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AArrowRoomDatabase::class.java,
                    "AArrow_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}