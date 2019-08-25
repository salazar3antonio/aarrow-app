package com.example.aarrowapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewEmployeeActivity : AppCompatActivity() {

    private lateinit var editEmployeeName: EditText
    private lateinit var saveEmployeeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_new)

        editEmployeeName = findViewById(R.id.et_employee_name)
        saveEmployeeButton = findViewById(R.id.btn_save_employee)
        saveEmployeeButton.setOnClickListener {

            val resultIntent = Intent()

            if (TextUtils.isEmpty(editEmployeeName.text)) {
                setResult(Activity.RESULT_CANCELED, resultIntent)
            } else {
                val employeeName = editEmployeeName.text.toString()
                resultIntent.putExtra(EXTRA_EMPLOYEE_NAME, employeeName)
                setResult(Activity.RESULT_OK, resultIntent)
            }
            finish()

        }

    }

    companion object {
        const val EXTRA_EMPLOYEE_NAME: String = "extra_employee_name"
    }

}