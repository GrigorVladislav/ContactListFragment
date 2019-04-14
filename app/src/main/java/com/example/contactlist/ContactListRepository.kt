package com.example.contactlist

import android.provider.MediaStore

object ContactListRepository {
    var list = listOf<UserInfo>()

    fun initList():List<UserInfo>{

       list = listOf(
            UserInfo("0", "Larysa","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image0),
            UserInfo("1", "Vova","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image1),
            UserInfo("2", "Artem","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image2),
            UserInfo("3", "Vera","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image3),
            UserInfo("4", "Olya","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image4),
            UserInfo("5", "Maks","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image5),
            UserInfo("6", "Igor'","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image6),
            UserInfo("7", "Lena","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image7),
            UserInfo("8", "Denis","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image8),
            UserInfo("9", "Stas","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image9),
            UserInfo("10", "Radion","Pypkin","066-123-123-11","alolalo@gogugle.com",R.drawable.image10))

        return list
    }

    fun getUserById(id:String):UserInfo?{
   for (item in list){
       if (item.id==id){
           return item
       }

        }
    return null
    }

}