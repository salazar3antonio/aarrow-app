package com.example.aarrowapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/*The Employee data model.
It will store details of each Employee inside of the Room Database.*/

@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    var employeeName: String,
    var employeeLocation: String,
    var avgAudit: Int,
    var appearanceTotal: Int,
    var advertisingTotal: Int,
    var energyTotal: Int,
    var technicalTotal: Int,
    var notes: String
)