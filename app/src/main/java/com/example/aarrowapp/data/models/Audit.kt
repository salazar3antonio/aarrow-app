package com.example.aarrowapp.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/*The Audit data model. An Audit is an Employee performance evaluation report.
There is a one-to-many relationship between the Employee and an Audit. One Employee can have many Audits, but only one Audit can be related to one Employee*/

@Entity(
    tableName = "audit_table",
    foreignKeys = [ForeignKey(
        entity = Employee::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("employeeId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Audit(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    var employeeId: Int,
    var employeeName: String,
    var location: String,
    var client: String,
    var date: String
)