package com.piplani.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn : Button =  findViewById(R.id.btn_start)
        val nameEt : EditText = findViewById(R.id.et_name)

        startBtn.setOnClickListener {
            if (nameEt.text.isNotEmpty()){
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,nameEt.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this,"Please Enter Name to proceed",Toast.LENGTH_LONG).show()
            }
        }
    }
}