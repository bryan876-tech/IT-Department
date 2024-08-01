package com.itdepartment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.itdepartment.R
import com.itdepartment.models.Faculty
import de.hdodenhof.circleimageview.CircleImageView


class DirectoryAdapter(val itemList: MutableList<Faculty>) :
    RecyclerView.Adapter<DirectoryAdapter.ModelViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DirectoryAdapter.ModelViewHolder {

        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_directory, parent, false)
        return ModelViewHolder(v)
    }

    override fun onBindViewHolder(holder: DirectoryAdapter.ModelViewHolder, position: Int) {

        holder.txtName.setText(itemList[position].name)
        holder.txtEmail.setText("Email: "+itemList[position].email)
        holder.txtPhone.setText("Phone: "+itemList[position].phone)
        Glide.with(holder.itemView.context)
            .load(itemList[position].photo)
            .override(300, 300)
            .apply(RequestOptions().placeholder(R.drawable.loading))
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: CircleImageView
        var txtName: TextView
        var txtEmail: TextView
        var txtPhone: TextView


        init {
            imgPhoto = itemView.findViewById(R.id.imgPhoto) as CircleImageView
            txtName = itemView.findViewById(R.id.txtName) as TextView
            txtEmail = itemView.findViewById(R.id.txtEmail) as TextView
            txtPhone = itemView.findViewById(R.id.txtPhone) as TextView
        }

    }
}