package com.sunasterisk.englishflashcard.ui.flashcard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.local.DictionaryLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.DictionaryDAOlmpl
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.activity_flashcard.*

class FlashcardActivity : AppCompatActivity(), FlashcardContract.View {

    private var presenter: FlashcardContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)
        setupActionBar()
        initDataTopics()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbarFlashcard)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.back)
            setHomeButtonEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    private fun initDataTopics() {
        val topicsDao = DictionaryDAOlmpl.getInstance(this)
        val localRepository: DictionaryRepository = DictionaryRepository.getInstance(
            local = DictionaryLocalDataSource.getInstance(topicsDao)
        )
        presenter = FlashcardPresenter(this, localRepository)
        val idTopic = intent.getIntExtra(EXTRA_ID, -1)
        presenter?.getAllDictionaries(idTopic.toString())
    }

    override fun showDictionaries(data: List<Dictionary>) {
        viewPagerFlashcard.adapter = FlashcardAdapter(data)
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
        const val EXTRA_ID: String = "idTopic"
        fun getIntent(context: Context, position: Int) =
            Intent(context, FlashcardActivity::class.java)
                .putExtra(EXTRA_ID, position)
    }
}
