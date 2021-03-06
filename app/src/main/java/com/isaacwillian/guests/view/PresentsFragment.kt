package com.isaacwillian.guests.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isaacwillian.guests.R
import com.isaacwillian.guests.service.constants.GuestConstants
import com.isaacwillian.guests.view.adapter.GuestAdapter
import com.isaacwillian.guests.view.listener.GuestListener
import com.isaacwillian.guests.viewmodel.GuestsViewModel

class PresentsFragment : Fragment() {

    private lateinit var mViewModel: GuestsViewModel
    private val mAdpater: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_presents, container, false)


        val recycler = root.findViewById<RecyclerView>(R.id.recycler_presents)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdpater

        observer()

        mListener = object : GuestListener{
            override fun onClick(id: Int) {
                val intent = Intent(context,GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID,id)

                intent.putExtras(bundle)


                startActivity(intent)

            }

            override fun onDelete(id: Int){
                mViewModel.delete(id)
                mViewModel.load(GuestConstants.FILTER.PRESENT)
            }

        }
        mAdpater.attachListener(mListener)

        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load(GuestConstants.FILTER.PRESENT)
    }

    fun observer(){
        mViewModel.guestList.observe(viewLifecycleOwner,Observer{
            mAdpater.updateGuest(it)

        })

    }
}