package com.e.booksrental_mobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.booksrental_mobile.Models.Book
import com.e.booksrental_mobile.R
import com.e.booksrental_mobile.ViewHolders.RentalBookListViewHolder
import com.e.booksrental_mobile.ViewHolders.RentalListViewHolder
import kotlinx.android.synthetic.main.book_simple_row.view.*

class RentalBookListAdapter(val bookList: Array<Book>): RecyclerView.Adapter<RentalBookListViewHolder>(){
    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalBookListViewHolder {
        val laoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = laoutInflater.inflate(R.layout.book_simple_row, parent, false)
        return RentalBookListViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: RentalBookListViewHolder, position: Int) {
        holder.view.book_title_text_view.text = bookList.get(position).title
        holder.view.book_release_date_text_view.text = bookList.get(position).release_year.toString()
        if(bookList.get(position).is_loan){
            holder.view.book_loan_status_button.setBackgroundResource(R.drawable.book_status_icon_taken)
        } else{
            holder.view.book_loan_status_button.setBackgroundResource(R.drawable.book_status_icon_free)
        }
        holder.view.book_row_layout.setOnClickListener {

        }
    }
}