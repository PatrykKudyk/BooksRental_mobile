package com.e.booksrental_mobile.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.booksrental_mobile.R
import com.e.booksrental_mobile.ViewHolders.RentalListViewHolder
import kotlinx.android.synthetic.main.rental_row.view.*

class RentalListAdapter: RecyclerView.Adapter<RentalListViewHolder>(){

    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalListViewHolder {
        val laoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = laoutInflater.inflate(R.layout.rental_row, parent, false)
        return RentalListViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: RentalListViewHolder, position: Int) {
        holder.view.rental_name_text_view.text = "Nazwa wypożyczalni"
        holder.view.rental_location_city_name.text = "Miasto"
        holder.view.rental_location_state_name.text = "województwo"
        holder.view.rental_location_street.text = "Adres"
    }
}