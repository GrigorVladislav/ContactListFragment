package com.example.contactlist

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    var imageId:Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity?.intent?.extras != null) {
            var entry_id = activity?.intent!!.getStringExtra("id")
            displayContact(entry_id)
        }

        detailImage.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

                goToThridScreen(imageId)

            } })

    }
    fun displayContact(index:String){
        val repo = ContactListRepository
        var user = repo.getUserById(index)
        if (user != null) {
            imageId = user.imageId
            name_view_detail.text = user.name
            second_name_view.text=user.secondName
            phone_number_view.text=user.phoneNumber
            email_view.text=user.email
            detailImage.setImageResource(user.imageId )}
    }

    fun goToThridScreen(id:Int){
        val intent= Intent(activity ,ThridScreen::class.java)
        intent.putExtra("id",id)
        this.startActivity(intent)
    }

    }


