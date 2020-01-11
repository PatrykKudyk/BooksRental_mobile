package com.e.booksrental_mobile.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.e.booksrental_mobile.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        register_button.setOnClickListener {
            if(areAllFieldsFilled()){

            }else{
                Toast.makeText(this, "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show()
            }
        }

        back_button.setOnClickListener {
            finish()
        }
    }

    private fun areAllFieldsFilled(): Boolean{
        var correctness: Boolean = true
        if(name_field.text.toString().equals("")){
            name_field.setError("Pole nie może być puste")
            correctness = false
        }
        if(last_name_field.text.toString().equals("")){
            last_name_field.setError("Pole nie może być puste")
            correctness = false
        }
        if(email_field.text.toString().equals("")){
            email_field.setError("Pole nie może być puste")
            correctness = false
        }
        if(login_field.text.toString().equals("")){
            login_field.setError("Pole nie może być puste")
            correctness = false
        }
        if(password_field.text.toString().equals("")){
            password_field.setError("Pole nie może być puste")
            correctness = false
        }
        if(password_repeat_field.text.toString().equals("")){
            password_repeat_field.setError("Pole nie może być puste")
            correctness = false
        }
        return correctness
    }

    override fun onBackPressed() {

    }
}
