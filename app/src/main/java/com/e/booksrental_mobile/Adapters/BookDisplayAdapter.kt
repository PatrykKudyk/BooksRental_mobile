package com.e.booksrental_mobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.booksrental_mobile.Models.Book
import com.e.booksrental_mobile.R
import com.e.booksrental_mobile.ViewHolders.BookDisplayViewHolder
import kotlinx.android.synthetic.main.book_detailed_row.view.*

class BookDisplayAdapter(val book: Book): RecyclerView.Adapter<BookDisplayViewHolder>(){
    override fun getItemCount(): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookDisplayViewHolder {
        val laoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = laoutInflater.inflate(R.layout.book_detailed_row, parent, false)
        return BookDisplayViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: BookDisplayViewHolder, position: Int) {
        holder.view.book_title_text_view.text = book.title
        holder.view.book_release_date_text_view.text = book.release_year.toString()
        holder.view.book_author_text_view.text = book.author_id.name + " " + book.author_id.lastName
        if(book._loan){
            holder.view.book_loan_status_button.setBackgroundResource(R.drawable.book_status_icon_taken)
        } else{
            holder.view.book_loan_status_button.setBackgroundResource(R.drawable.book_status_icon_free)
        }
        holder.view.book_pages_text_view.text = holder.view.context.getString(R.string.pages) + book.pages
        if(book._thick_cover){
            holder.view.book_cover_type_text_view.text = holder.view.context.getString(R.string.thick_cover)
        }else{
            holder.view.book_cover_type_text_view.text = holder.view.context.getString(R.string.thin_cover)
        }
        holder.view.book_publishing_house_text_view.text = holder.view.context.getString(R.string.publishing_house) +
                book.publishing_house_id.name
        holder.view.book_rental_text_view.text = holder.view.context.getString(R.string.rental_place) +
                book.rental_id.name
        holder.view.book_rental_address_text_view.text = book.rental_id.location.street + " " +
                book.rental_id.location.building_number + "/" + book.rental_id.location.office_number +
                ", " + book.rental_id.location.city
    }


}