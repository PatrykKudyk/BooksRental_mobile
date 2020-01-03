package com.e.booksrental_mobile.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.e.booksrental_mobile.R
import kotlin.math.log

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginEditText = this.findViewById(R.id.login_field) as EditText
        val passwordEditText = this.findViewById(R.id.password_field) as EditText

        val loginButton = this.findViewById(R.id.login_button) as Button

        loginButton.setOnClickListener{
            if(areFieldsFilled(loginEditText, passwordEditText)){

            }else{
                Toast.makeText(this,"Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun areFieldsFilled(login: EditText, password: EditText): Boolean{
        var isCorrect = false
        if(login.text.toString().equals("")){
            login.setError("Pole nie może być puste")
        }else{
            isCorrect = true
        }
        if(password.text.toString().equals("")) {
            password.setError("Pole nie może być puste")
            isCorrect = false
        }
        return isCorrect
    }

//    private fun checkUser(login: String, password: String): Int{
//
//    }

    override fun onBackPressed() {

    }
}
