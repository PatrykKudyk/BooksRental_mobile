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
            if(testFieldsCorrectness()){
                Toast.makeText(this, "Dane są poprawne", Toast.LENGTH_SHORT).show()
            }
        }

        back_button.setOnClickListener {
            finish()
        }
    }

    private fun testFieldsCorrectness(): Boolean{
        var correctness = true
        if(!areAllFieldsFilled()){
            correctness = false
            Toast.makeText(this, "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show()
        }
        if(!email_field.text.toString().equals("")){
            if(!isEmailCorrect()){
                correctness = false
            }
        }
        if(!(password_field.text.toString().equals("") || password_repeat_field.text.toString().equals(""))){
            if(!arePasswordsCorrect()){
                correctness = false
            }
        }
        return correctness
    }

    private fun areAllFieldsFilled(): Boolean{
        var correctness = true
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

    private fun isEmailCorrect(): Boolean{
        var email = email_field.text.toString()
        var emailSplitted = email.split("@")
        if(emailSplitted.size != 2){
            email_field.setError("Podany email jest niepoprawny")
            return false
        }
        var secondEmailSplit = emailSplitted[1].split(".")
        if(secondEmailSplit.size != 2){
            email_field.setError("Podany email jest niepoprawny")
            return false
        }
        return true
    }

    private fun arePasswordsCorrect(): Boolean{
        var correctness = true
        if(!password_field.text.toString().equals(password_repeat_field.text.toString())){
            password_repeat_field.setError("Hasła muszą być takie same")
            correctness = false
        }
        return correctness
    }

    override fun onBackPressed() {

    }
}
