package com.e.booksrental_mobile.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.e.booksrental_mobile.Activities.Admin.AdminMainMenu
import com.e.booksrental_mobile.Activities.User.UserMainMenu
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
                val userType: Int = checkUser(loginEditText.text.toString(),
                    passwordEditText.text.toString())
                if(userType == 3){
                    Toast.makeText(this, "Podane dane są niepoprawne",
                        Toast.LENGTH_SHORT).show()
                }else{
                    if(userType == 1){
                        val intent = Intent(this, AdminMainMenu::class.java)
                        startActivity(intent)
                    }else if(userType == 2){
                        val intent = Intent(this, UserMainMenu::class.java)
                        startActivity(intent)
                    }
                }
                loginEditText.text.clear()
                passwordEditText.text.clear()
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

    private fun checkUser(login: String, password: String): Int{
        if(login.equals("admin") && password.equals("admin")){
            return 1
        }else if(login.equals("user") && password.equals("user")){
            return 2
        }else{
            return 3
        }
    }

    override fun onBackPressed() {

    }
}
