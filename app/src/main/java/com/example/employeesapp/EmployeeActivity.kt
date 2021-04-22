package com.example.employeesapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.employee_item.*
import org.json.JSONObject

class EmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val employeeString = bundle!!.getString("employee")
            val employee = JSONObject(employeeString)

            nameView.text = employee["firstName"].toString() + " " + employee["lastName"].toString()
            titleView.text = employee["title"].toString()
            departmentView.text = employee["department"].toString()
            phoneView.text = employee["phone"].toString()
            emailView.text = employee["email"].toString()

            Glide.with(imageView.context)
                .load(employee["image"].toString())
                .into(imageView)
        }
    }
}
