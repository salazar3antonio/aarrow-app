package com.example.aarrowapp.database.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/*The AuditEntity data model. An AuditEntity is an EmployeeEntity performance evaluation report.
There is a one-to-many relationship between the EmployeeEntity and an AuditEntity. One EmployeeEntity can have many Audits, but only one AuditEntity can be related to one EmployeeEntity*/

@Entity(
    tableName = "audit_table",
    foreignKeys = [ForeignKey(
        entity = EmployeeEntity::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("employeeId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class AuditEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    var employeeId: Int,
    var employeeName: String,
    var clientLocation: String,
    var clientName: String,
    var date: String,
    var appearanceTotal: Int,
    var smilePoints: Int,
    var uniformPoints: Int,
    var stylePoints: Int,
    var directionPoints: Int,
    var positioningPoints: Int,
    var advertisingTotal: Int,
    var aamPoints: Int,
    var presentationPoints: Int,
    var eyecontactPoints: Int,
    var awarenessPoints: Int,
    var safetyPoints: Int,
    var energyTotal: Int,
    var personalityPoints: Int,
    var spinteractionPoints: Int,
    var dancingPoints: Int,
    var endurancePoints: Int,
    var recoveryPoints: Int,
    var technicalTotal: Int,
    var difficultyPoints: Int,
    var powerPoints: Int,
    var transitionPoints: Int,
    var catchPoints: Int,
    var freezePoints: Int,
    var bonusPoints: Int,
    var demeritPoints: Int,
    var doingGreatAt: String,
    var improvements: String
)