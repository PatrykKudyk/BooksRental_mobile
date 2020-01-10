package com.e.booksrental_mobile.Models

class Rental(val id: Long, val name: String, val books: List<Book>, val location_id: Location) {
}