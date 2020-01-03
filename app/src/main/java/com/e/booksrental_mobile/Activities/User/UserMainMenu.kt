package com.e.booksrental_mobile.Activities.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.e.booksrental_mobile.R

class UserMainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main_menu)

        val rentalBooksButton = this.findViewById(R.id.show_rentals_button) as Button
        val authorBooksButton = this.findViewById(R.id.show_author_books_button) as Button
        val booksByNameButton = this.findViewById(R.id.search_books_by_name_button) as Button

        rentalBooksButton.setOnClickListener {
            val intent = Intent(this, RentalListActivity::class.java)
            startActivity(intent)
        }

        authorBooksButton.setOnClickListener {

        }

        booksByNameButton.setOnClickListener {

        }

    }

    override fun onBackPressed() {

    }
}
