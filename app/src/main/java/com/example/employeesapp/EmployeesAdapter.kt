package com.example.employeesapp


import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.json.JSONArray
import kotlinx.android.synthetic.main.employee_item.view.*



class EmployeesAdapter(private val employees: JSONArray) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.employee_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = employees.length()

    override fun onBindViewHolder(holder: EmployeesAdapter.ViewHolder, position: Int) {
        val employee =  employees.getJSONObject(position)

        Glide.with(holder.pictureImageView.context)
            .load(employee["image"].toString())
            .into(holder.pictureImageView)

        holder.nameTextView.text = employee["lastName"].toString() + " " + employee["firstName"].toString()
        holder.emailTextView.text = employee["email"].toString()
        holder.phoneTextView.text = employee["phone"].toString()
        holder.titleTextView.text = employee["title"].toString()
        holder.departmentTextView.text = employee["department"].toString()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.nameView
        val emailTextView: TextView = view.emailView
        val phoneTextView: TextView = view.phoneView
        val titleTextView: TextView = view.titleView
        val departmentTextView: TextView = view.departmentView
        var pictureImageView: ImageView = view.imageView

        init{
            itemView.setOnClickListener {
                val intent = Intent(view.context, EmployeeActivity::class.java)
                intent.putExtra("employee",employees[adapterPosition].toString())
                view.context.startActivity(intent)
            }
        }
    }
}