package com.isaacwillian.guests.view.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.isaacwillian.guests.R
import com.isaacwillian.guests.service.model.GuestModel
import com.isaacwillian.guests.view.listener.GuestListener
import com.isaacwillian.guests.view.viewholder.GuestViewHolder

class GuestAdapter() :RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList:List<GuestModel> = arrayListOf()
    private lateinit var mListener:GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest,parent,false)
        return GuestViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])


    }

    fun updateGuest(list:List<GuestModel>){
        mGuestList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener:GuestListener){
        mListener = listener
    }

}