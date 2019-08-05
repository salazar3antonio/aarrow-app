package com.example.aarrowapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aarrowapp.database.daos.AuditDao
import com.example.aarrowapp.database.daos.EmployeeDao
import com.example.aarrowapp.database.models.AuditEntity
import com.example.aarrowapp.database.models.EmployeeEntity

@Database(entities = [EmployeeEntity::class, AuditEntity::class], version = 2)
abstract class AArrowRoomDatabase : RoomDatabase() {

    //abstract "getter" method for each @Dao
    abstract fun employeeDao(): EmployeeDao
    abstract fun auditDao(): AuditDao

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
                    "aarrow_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}