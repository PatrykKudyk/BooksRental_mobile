package com.e.booksrental_mobile.Models

class Book(val id: Long, val title: String, val release_year: Int, val pages: Int,
           val is_thick_cover: Boolean, val is_loan: Boolean, val rental_id: Rental,
           val publishing_house_id: PublishingHouse, val author_id: Author) {
}