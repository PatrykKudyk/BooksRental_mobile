package com.e.booksrental_mobile.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.booksrental_mobile.Activities.User.RentalBooksListActivity
import com.e.booksrental_mobile.Activities.User.RentalListActivity
import com.e.booksrental_mobile.Models.Rental
import com.e.booksrental_mobile.R
import com.e.booksrental_mobile.ViewHolders.RentalListViewHolder
import kotlinx.android.synthetic.main.rental_row.view.*

class RentalListAdapter(val rentalList: Array<Rental>): RecyclerView.Adapter<RentalListViewHolder>(){

    override fun getItemCount(): Int {
        return rentalList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalListViewHolder {
        val laoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = laoutInflater.inflate(R.layout.rental_row, parent, false)
        return RentalListViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: RentalListViewHolder, position: Int) {
        holder.view.rental_name_text_view.text = rentalList.get(position).name
        holder.view.rental_location_city_name.text = rentalList.get(position).location_id.city
        holder.view.rental_location_state_name.text = rentalList.get(position).location_id.state
        holder.view.rental_location_street.text = rentalList.get(position).location_id.street +
                " " + rentalList.get(position).location_id.building_number + "/" +
                rentalList.get(position).location_id.office_number

        holder.view.rental_row_layout.setOnClickListener {
            val intent = Intent(holder.view.context ,RentalBooksListActivity::class.java)
            intent.putExtra("rentalId", rentalList.get(position).id.toInt())
            holder.view.context.startActivity(intent)
        }
    }
}