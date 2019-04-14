package com.example.contactlist

import android.content.Context
import android.content.Intent
import android.net.sip.SipAudioCall
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_raw.view.*

class MainAdapter(val items:List<UserInfo>, val context: Context):RecyclerView.Adapter<CustomViewHolder>() {

    private lateinit var listener: Listener
    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    val repo = ContactListRepository
    val list = repo.initList()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.layout_raw,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       val user = list.get(position)
    holder.view.name_view.text = user.name
        holder.view.number_view.text=user.phoneNumber
        holder.view.Photo.setImageResource(user.imageId)
//        holder.ClickItem(user.id)
        holder.view.setOnClickListener{
            listener.onClick(position)
        }
    }


}

class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view){


fun ClickItem ( id:String){
    view.setOnClickListener{
//        val intent = Intent(view.context,DetailActivity::class.java)
//        intent.putExtra("id", id)
//        view.context.startActivity(intent)

    }
}

}