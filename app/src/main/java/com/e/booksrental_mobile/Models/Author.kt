package com.e.booksrental_mobile.Models

class Author(val id: Long, val name: String, val lastName: String, val age: Int,
             val books: List<Book>) {
}