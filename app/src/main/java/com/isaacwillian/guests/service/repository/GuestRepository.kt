package com.isaacwillian.guests.service.repository

import android.content.ContentValues
import android.content.Context
import com.isaacwillian.guests.service.constants.DataBaseConstants
import com.isaacwillian.guests.service.model.GuestModel

class GuestRepository (context: Context) {

    private val mDataBase = GuestDataBase.getDatabase(context).guestDAO()


    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun get(id: Int): GuestModel {
         return mDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()

    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0

    }

    fun delete(guest: GuestModel) {
        mDataBase.delete(guest)


    }

}