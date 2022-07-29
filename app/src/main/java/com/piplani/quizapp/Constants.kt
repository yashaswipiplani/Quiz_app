package com.piplani.quizapp

import java.util.ArrayList

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_QUESTIONS: String = "correct_questions"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val ques1 = Question(1,"Which country does the following flag belong to?",R.drawable.ic_flag_of_argentina,
        "Argentina","Armenia","India", "Australia",1)
        questionsList.add(ques1)

        val ques2 = Question(2,"Which country does the following flag belong to?",R.drawable.ic_flag_of_australia,
            "Austria","Armenia","Cuba", "Australia",4)
        questionsList.add(ques2)

        val ques3 = Question(3,"Which country does the following flag belong to?",R.drawable.ic_flag_of_belgium,
            "Pakistan","Belgium","China", "Colombia",2)
        questionsList.add(ques3)

        val ques4 = Question(4,"Which country does the following flag belong to?",R.drawable.ic_flag_of_brazil,
            "Argentina","Africa","India", "Brazil",4)
        questionsList.add(ques4)

        val ques5 = Question(5,"Which country does the following flag belong to?",R.drawable.ic_flag_of_denmark,
            "Denmark","Armenia","Colombia", "Germany",1)
        questionsList.add(ques5)

        val ques6 = Question(6,"Which country does the following flag belong to?",R.drawable.ic_flag_of_fiji,
            "Fiji","Armenia","India", "Australia",1)
        questionsList.add(ques6)

        val ques7 = Question(7,"Which country does the following flag belong to?",R.drawable.ic_flag_of_germany,
            "Africa","UAE","Germany", "Brazil",3)
        questionsList.add(ques7)

        val ques8 = Question(8,"Which country does the following flag belong to?",R.drawable.ic_flag_of_india,
            "Argentina","Nepal","China", "India",4)
        questionsList.add(ques8)

        val ques9 = Question(9,"Which country does the following flag belong to?",R.drawable.ic_flag_of_kuwait,
            "Nepal","Cuba","Kuwait", "UAE",3)
        questionsList.add(ques9)

        val ques10 = Question(10,"Which country does the following flag belong to?",R.drawable.ic_flag_of_new_zealand,
            "New Zealand","Fiji","India", "Australia",1)
        questionsList.add(ques10)

        return questionsList
    }
}