package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


class UsersAdapter(users: List<UsersItem?>?) : Adapter<UsersAdapter.UsersHolder>() {

    lateinit var context: Context

    var Userlist = users

    class UsersHolder(itemView: View) : ViewHolder(itemView) {

        var imeusers = itemView.findViewById<ImageView>(R.id.imeg)
        var txtname = itemView.findViewById<TextView>(R.id.txtname)
        var txtsurnam = itemView.findViewById<TextView>(R.id.txtsruname)
        var txtage = itemView.findViewById<TextView>(R.id.txtage)
        var txtgender = itemView.findViewById<TextView>(R.id.txtgender)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        context = parent.context
        return UsersHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return Userlist?.size!!
    }

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {

        holder.txtname.text = Userlist?.get(position)?.firstName
        holder.txtsurnam.text = Userlist?.get(position)?.lastName
        holder.txtage.text = Userlist?.get(position)?.age.toString()
        holder.txtgender.text = Userlist?.get(position)?.gender
        Glide.with(context).load(Userlist?.get(position)?.image).into(holder.imeusers)


    }
}