package com.e.booksrental_mobile.Models

class Location(val id: Long, val state: String, val city: String, val zip_code: String,
               val street: String, val building_number: String, val office_number: String,
               val _used: Boolean, val publishing_house_id: PublishingHouse, val rental_id: Rental) {
}