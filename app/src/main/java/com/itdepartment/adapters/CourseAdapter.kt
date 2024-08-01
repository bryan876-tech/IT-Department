package com.itdepartment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import at.blogc.android.views.ExpandableTextView

import com.itdepartment.R
import com.itdepartment.models.Course



class CourseAdapter(val itemList: MutableList<Course>) :
    RecyclerView.Adapter<CourseAdapter.ModelViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseAdapter.ModelViewHolder {

        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ModelViewHolder(v)
    }

    override fun onBindViewHolder(holder: CourseAdapter.ModelViewHolder, position: Int) {

        holder.txtCode.setText(itemList[position].code)
        holder.txtCredits.setText(itemList[position].credits.toString())
        holder.txtTitle.setText(itemList[position].title)
        holder.txtPreRequisites.setText(itemList[position].pre_requisites)
        holder.expandableTextView.setText(itemList[position].description)
        holder.btnExpand.setOnClickListener {
            holder.expandableTextView.toggle()
            holder.btnExpand.animate().rotationBy(180f).setDuration(500).start()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCode: TextView
        var txtCredits: TextView
        var txtTitle: TextView
        var expandableTextView: ExpandableTextView
        var txtPreRequisites: TextView
        var btnExpand: AppCompatImageButton


        init {
            txtCode = itemView.findViewById(R.id.txtCode) as TextView
            txtCredits = itemView.findViewById(R.id.txtCredits) as TextView
            txtTitle = itemView.findViewById(R.id.txtTitle) as TextView
            expandableTextView = itemView.findViewById(R.id.expandableTextView) as ExpandableTextView
            btnExpand = itemView.findViewById(R.id.btnExpand) as AppCompatImageButton


            txtPreRequisites = itemView.findViewById(R.id.txtPreRequisites) as TextView
        }

    }
}