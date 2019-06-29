package com.example.aarrowapp.data

import java.util.*

data class Audit (
    var employeeName: String,
    var auditNum: Int,
    var location: String,
    var client: String,
    var date: Date
)