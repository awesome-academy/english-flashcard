package com.sunasterisk.englishflashcard.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.ui.exam.ExamFragment
import com.sunasterisk.englishflashcard.ui.addtopic.AddTopicFragment
import com.sunasterisk.englishflashcard.ui.learn.LearnFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageLearn.setOnClickListener(this)
        imageExam.setOnClickListener(this)
        floatButtonAdd.setOnClickListener(this)
        replaceFragment(LearnFragment())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imageLearn -> replaceFragment(LearnFragment())
            R.id.imageExam -> replaceFragment(ExamFragment())
            R.id.floatButtonAdd -> replaceFragment(AddTopicFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}
