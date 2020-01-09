package com.e.booksrental_mobile.Activities.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.booksrental_mobile.Adapters.RentalBookListAdapter
import com.e.booksrental_mobile.Models.Book
import com.e.booksrental_mobile.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_rental_books_list.*
import okhttp3.*
import java.io.IOException

class RentalBooksListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental_books_list)

        val rentalId = intent.getSerializableExtra("rentalId") as Int

        books_list_recycler_view.layoutManager = LinearLayoutManager(this)

        val backButton = this.findViewById(R.id.back_button) as Button

        fetchBookList(rentalId)

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun fetchBookList(rentalId: Int) {

        val url = "http://books-rental-backend.eu-central-1.elasticbeanstalk.com/rental/" +
                rentalId.toString()

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val books = gson.fromJson(body, Array<Book>::class.java)

                runOnUiThread{
                    books_list_recycler_view.adapter = RentalBookListAdapter(books)
                }
            }
        })

    }


    override fun onBackPressed() {

    }
}
