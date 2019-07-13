package com.example.aarrowapp.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/*The EmployeeEntity data model.
It will store details of each EmployeeEntity inside of the Room Database.*/

@Entity(tableName = "employee_table")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    var employeeName: String,
    var employeeAddress: String,
    var employeePhoneNumber: String,
    var avgAudit: Int,
    var appearanceTotal: Int,
    var advertisingTotal: Int,
    var energyTotal: Int,
    var technicalTotal: Int,
    var notes: String
)