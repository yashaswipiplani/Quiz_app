package com.piplani.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition : Int = 1
    private var questionsList : ArrayList<Question>? = null
    private var selectedOption : Int = 0
    private var correctQuestions : Int = 0
    private var userName : String? = null
    private var isAnswered : Boolean = false

    private var tvQuestion : TextView? = null
    private var ivFlag : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvOption1 : TextView? = null
    private var tvOption2 : TextView? = null
    private var tvOption3 : TextView? = null
    private var tvOption4 : TextView? = null
    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        userName = intent.getStringExtra(Constants.USER_NAME)

        tvQuestion = findViewById(R.id.question_text)
        ivFlag = findViewById(R.id.flag_image)
        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.progress_txt)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        questionsList = Constants.getQuestions()

        displayQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun displayQuestion() {
        defaultOptionsView()
        val question = questionsList!![currentPosition - 1]
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4
        ivFlag?.setImageResource(question.image)
        btnSubmit?.text = "SUBMIT"
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it)
        }
        tvOption2?.let{
            options.add(1,it)
        }
        tvOption3?.let{
            options.add(2,it)
        }
        tvOption4?.let{
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_tv_bg)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        selectedOption = selectedOptionNum

        tv.setTextColor((Color.parseColor("#363A43")))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_tv_bg)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1 -> {
                if(!isAnswered) {
                    tvOption1?.let { selectedOptionView(it, 1) }
                }
            }
            R.id.tv_option2 -> {
                if (!isAnswered) {
                    tvOption2?.let { selectedOptionView(it, 2) }
                }
            }
            R.id.tv_option3 -> {
                if(!isAnswered) {
                    tvOption3?.let { selectedOptionView(it, 3) }
                }
            }
            R.id.tv_option4 -> {
                if (!isAnswered) {
                    tvOption4?.let { selectedOptionView(it, 4) }
                }
            }
            R.id.btn_submit -> {
                if (selectedOption == 0){
                    if (currentPosition+1 <= questionsList!!.size){
                        if (isAnswered) {
                            currentPosition++
                            displayQuestion()
                            isAnswered = false
                        }
                        else
                            Toast.makeText(this, "Please choose an option",Toast.LENGTH_SHORT).show()
                    }
                    else if(currentPosition==questionsList!!.size && isAnswered) {
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, userName)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,questionsList!!.size)
                        intent.putExtra(Constants.CORRECT_QUESTIONS, correctQuestions)
                        startActivity(intent)
                        finish()
                    }
                    else
                        Toast.makeText(this, "Please choose an option",Toast.LENGTH_SHORT).show()
                }else {
                    val question = questionsList?.get(currentPosition-1)
                    if (question!!.correctOption != selectedOption){
                        optionBgColor(selectedOption, R.drawable.wrong_tv_bg)
                    } else {
                        correctQuestions++
                    }
                    optionBgColor(question.correctOption, R.drawable.correct_tv_bg)
                    selectedOption = 0
                    isAnswered = true

                    if(currentPosition == questionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                }
            }
        }
    }

    private fun optionBgColor(option:Int, drawable:Int){
       when(option){
           1 -> {
               tvOption1?.background = ContextCompat.getDrawable(this, drawable)
           }
           2-> {
               tvOption2?.background = ContextCompat.getDrawable(this, drawable)
           }
           3 -> {
               tvOption3?.background = ContextCompat.getDrawable(this, drawable)
           }
           4 -> {
               tvOption4?.background = ContextCompat.getDrawable(this, drawable)
           }
       }
    }
}