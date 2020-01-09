package com.e.booksrental_mobile.Activities.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.booksrental_mobile.Adapters.RentalListAdapter
import com.e.booksrental_mobile.Models.Rental
import com.e.booksrental_mobile.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_rental_list.*
import okhttp3.*
import java.io.IOException

class RentalListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental_list)

//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//
//        rental_list_recycler_view_user.layoutParams.height = displayMetrics.heightPixels - 256
        rental_list_recycler_view_user.layoutManager = LinearLayoutManager(this)

        val backButton = this.findViewById(R.id.back_button) as Button

        fetchRentalList()

        backButton.setOnClickListener {
            finish()
        }

    }

    fun fetchRentalList(){
        val url = "http://books-rental-backend.eu-central-1.elasticbeanstalk.com/rental/"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val rentals = gson.fromJson(body, Array<Rental>::class.java)

                runOnUiThread{
                    rental_list_recycler_view_user.adapter = RentalListAdapter(rentals)
                }
            }
        })

    }


    override fun onBackPressed() {

    }
}
