package com.isaacwillian.guests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaacwillian.guests.service.constants.GuestConstants
import com.isaacwillian.guests.service.model.GuestModel
import com.isaacwillian.guests.service.repository.GuestRepository

class GuestsViewModel(application:Application) : AndroidViewModel(application) {

    private val mGuestRepository: GuestRepository = GuestRepository(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()

    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter:Int){

        if(filter == GuestConstants.FILTER.EMPTY){
            mGuestList.value = mGuestRepository.getAll()
        }else if (filter ==  GuestConstants.FILTER.PRESENT){
            mGuestList.value = mGuestRepository.getPresent()
        } else {
             mGuestList.value = mGuestRepository.getAbsent()
        }

    }

    fun delete(id:Int){
        val guest = mGuestRepository.get(id)
        mGuestRepository.delete(guest)

    }
}