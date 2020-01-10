package com.e.booksrental_mobile.Activities.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.booksrental_mobile.Adapters.BookDisplayAdapter
import com.e.booksrental_mobile.Models.Book
import com.e.booksrental_mobile.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_book_info_display.*
import okhttp3.*
import java.io.IOException

class BookInfoDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info_display)

        val bookId = intent.getSerializableExtra("bookId") as Long

        book_detailed_info_recycler_view.layoutManager = LinearLayoutManager(this)

        fetchBook(bookId)
    }

    private fun fetchBook(id: Long){
        val url = "http://books-rental-backend.eu-central-1.elasticbeanstalk.com/book/" +
                id.toString()

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val book = gson.fromJson(body, Book::class.java)

                runOnUiThread{
                    book_detailed_info_recycler_view.adapter = BookDisplayAdapter(book)
                }
            }
        })
    }
}
