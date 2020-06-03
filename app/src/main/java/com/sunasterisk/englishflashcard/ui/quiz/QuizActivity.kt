package com.sunasterisk.englishflashcard.ui.quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Quiz
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.local.DictionaryLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.DictionaryDAOlmpl
import com.sunasterisk.englishflashcard.ui.flashcard.QuizAdapter
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), QuizContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setupActionBar()
        initDataDictionary()
    }

    private fun initDataDictionary() {
        val dictionaryDao = DictionaryDAOlmpl.getInstance(this)
        val repository = DictionaryRepository.getInstance(
            local = DictionaryLocalDataSource.getInstance(dictionaryDao)
        )
        val presenter = QuizPresenter(this, repository)
        val idTopic = intent.getIntExtra(EXTRA_ID, -1)
        presenter.getDataWordEnglish(idTopic.toString())
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbarQuiz)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.back)
            setHomeButtonEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun showDataWordEnglish(data: List<Quiz>) {
        val quiz = data.toMutableList()
        viewPagerExamDetail.adapter = QuizAdapter(quiz, viewPagerExamDetail)
    }

    override fun showError(exception: Exception) {
        toast(exception.message.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val EXTRA_ID: String = "idTopic"
        fun getIntent(context: Context, position: Int) = Intent(context, QuizActivity::class.java)
            .putExtra(EXTRA_ID, position)
    }
}
