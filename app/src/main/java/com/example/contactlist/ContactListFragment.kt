package com.example.contactlist

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import kotlinx.android.synthetic.main.fragment_contact_list.*


class ContactListFragment : Fragment() {
    lateinit var contacts: List<UserInfo>
    lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


       contacts =ContactListRepository.initList()

//        recyclerView_main.layoutManager = LinearLayoutManager(activity)
//        recyclerView_main.adapter = MainAdapter()
        adapter = MainAdapter(contacts,context!!)
        activity!!.recyclerView_main.layoutManager = LinearLayoutManager(activity)
        adapter.setListener(object : MainAdapter.Listener{
            override fun onClick(position: Int) {
                contactClick(position)

            }
        })
        activity!!.recyclerView_main.adapter =adapter

    }
    fun contactClick(id:Int){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra("id",id.toString() )
            startActivity(intent)

        }else{
            val detailsFragment = fragmentManager!!.findFragmentById(R.id.details_fragment) as DetailsFragment
            detailsFragment.displayContact(id.toString())
        }
    }
}
