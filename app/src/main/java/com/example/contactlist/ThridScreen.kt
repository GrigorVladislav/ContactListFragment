package com.example.contactlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.third_screen.*

class ThridScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_screen)

        if (intent!=null){

            var id = intent.getIntExtra("id",0)
            mainimage.setImageResource(id)
        }
    }

}
