package com.piplani.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvUserName = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinish = findViewById<Button>(R.id.btn_finish)

        val correctQuestions = intent.getIntExtra(Constants.CORRECT_QUESTIONS,0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        tvUserName.text = intent.getStringExtra(Constants.USER_NAME)
        tvScore.text = "Your score is $correctQuestions out of $totalQuestions"
        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}