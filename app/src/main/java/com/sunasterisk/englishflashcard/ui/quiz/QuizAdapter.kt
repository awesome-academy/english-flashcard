package com.sunasterisk.englishflashcard.ui.flashcard

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Quiz
import kotlinx.android.synthetic.main.quiz_item.view.*
import com.sunasterisk.englishflashcard.ui.toast

class QuizAdapter(
    private val quizs: List<Quiz>,
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<ExamDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamDetailsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quiz_item, parent, false)
        return ExamDetailsViewHolder(view, quizs, viewPager)
    }

    override fun getItemCount() = quizs.size

    override fun onBindViewHolder(holder: ExamDetailsViewHolder, position: Int) {
        holder.bindData(quizs[position])
    }

}

class ExamDetailsViewHolder(
    itemView: View,
    private val items: List<Quiz>,
    private val viewPager: ViewPager2
) : RecyclerView.ViewHolder(itemView) {

    private var checkCorrect = ""
    private val TIME_LOAD_NEXT = 1500
    private val TIME_LOAD_BUTTON = 1500

    private val buttons = listOf<Button>(
        itemView.buttonAnswerA,
        itemView.buttonAnswerB,
        itemView.buttonAnswerC,
        itemView.buttonAnswerD
    )

    init {
        buttons.forEach {
            it.setOnClickListener {
                checkCorrect(it as Button)
            }
        }
    }

    private fun checkCorrect(button: Button) {
        if (button.text.toString() == checkCorrect) {
            button.setBackgroundResource(R.drawable.boder_button_correct)
            setColorButton(button)
            numberCorrect++
        } else {
            button.setBackgroundResource(R.drawable.boder_button_wrong)
            setColorButton(button)
            buttons.forEach {
                if (it != button && it.text == checkCorrect) {
                    it.setBackgroundResource(R.drawable.boder_button_correct)
                    setColorButton(it)
                }
            }
        }
        if (viewPager.currentItem < items.size - 1) {
            setColorButton1(viewPager)
        } else {
            itemView.context.toast(numberCorrect.toString() + itemView.context.getString(R.string.messeage_over_10))
            viewPager.setCurrentItem(0, true)
            numberCorrect = 0
        }
    }

    internal fun bindData(quiz: Quiz) {
        itemView.apply {
            textViewQuestion.text = quiz.question
            buttonAnswerA.text = quiz.answerA
            buttonAnswerB.text = quiz.answerB
            buttonAnswerC.text = quiz.answerC
            buttonAnswerD.text = quiz.answerD
            checkCorrect = quiz.check
        }
    }

    private fun setColorButton1(viewPager: ViewPager2) {
        Handler().postDelayed({
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }, TIME_LOAD_NEXT.toLong())
    }

    private fun setColorButton(button: Button) {
        Handler().postDelayed({
            button.setBackgroundResource(R.drawable.boder_button_answer)
        }, TIME_LOAD_BUTTON.toLong())
    }

    companion object {
        private var numberCorrect = 0
    }
}
