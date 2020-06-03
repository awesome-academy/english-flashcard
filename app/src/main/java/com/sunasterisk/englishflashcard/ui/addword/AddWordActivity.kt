package com.sunasterisk.englishflashcard.ui.addword

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.sunasterisk.englishflashcard.ui.toast
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.local.DictionaryLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.DictionaryDAOlmpl
import kotlinx.android.synthetic.main.activity_add_word.*
import kotlinx.android.synthetic.main.activity_add_word.buttonExit

class AddWordActivity : AppCompatActivity(), AddWordContract.View {

    private var presenter: AddWordContract.Presenter? = null
    private var wordType: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        initDataTopics()
        setClickEvents()
    }

    private fun setClickEvents() {
        buttonAddWord.setOnClickListener {
            insertWord()
        }
        buttonExit.setOnClickListener {
            finish()
        }
        checkEnglishType()
    }

    private fun insertWord() {
        val idTopic = intent.getIntExtra(EXTRA_ID, -1)
        when {
            editTextEnglishWord.text.isEmpty() -> {
                toast(getString(R.string.messeage_english_word_not_be_empty))
            }
            editTextSpelling.text.isEmpty() -> {
                toast(getString(R.string.messeage_spelling_not_be_empty))
            }
            editTextTranslate.text.isEmpty() -> {
                toast(getString(R.string.messeage_translate_not_be_empty))
            }
            wordType.isEmpty() -> {
                toast(getString(R.string.messeage_wordtype_not_be_empty))
            }
            else -> {
                presenter?.addWord(
                    Dictionary(
                        0,
                        editTextEnglishWord.text.toString(),
                        wordType,
                        editTextSpelling.text.toString(),
                        editTextTranslate.text.toString(),
                        idTopic
                    )
                )
                finish()
            }
        }
    }

    private fun checkRadio(radioButton: RadioButton) {
        val arrRadio = arrayOf<RadioButton>(
            radioNoun,
            radioAdverbs,
            radioPreposition,
            radioVerb,
            radioAdjective
        )
        for (i in arrRadio.indices) {
            if (arrRadio[i] == radioButton) {
                continue
            }
            arrRadio[i].isChecked = false
        }
    }

    private fun checkEnglishType() {
        radioNoun.setOnClickListener {
            if (radioNoun.isChecked) {
                wordType = ""
                checkRadio(radioNoun)
                wordType = radioNoun.text.toString()
            }
        }
        radioPreposition.setOnClickListener {
            if (radioPreposition.isChecked) {
                wordType = ""
                checkRadio(radioPreposition)
                wordType = radioPreposition.text.toString()
            }
        }
        radioVerb.setOnClickListener {
            if (radioVerb.isChecked) {
                wordType = ""
                checkRadio(radioVerb)
                wordType = radioVerb.text.toString()
            }
        }
        radioAdjective.setOnClickListener {
            if (radioAdjective.isChecked) {
                wordType = ""
                checkRadio(radioAdjective)
                wordType = radioAdjective.text.toString()
            }
        }
        radioAdverbs.setOnClickListener {
            if (radioAdverbs.isChecked) {
                wordType = ""
                checkRadio(radioAdverbs)
                wordType = radioAdverbs.text.toString()
            }
        }
    }

    private fun initDataTopics() {
        val topicsDao = DictionaryDAOlmpl.getInstance(this)
        val localRepository: DictionaryRepository = DictionaryRepository.getInstance(
            local = DictionaryLocalDataSource.getInstance(topicsDao)
        )
        presenter = AddWordPresenter(this, localRepository)
    }

    override fun notifyMessage(messageResId: Int) {
        toast(getString(messageResId))
    }

    override fun showError(exception: Exception) {
        toast(exception.message.toString())
    }

    companion object {
        const val EXTRA_ID: String = "idTopic"
        fun getIntent(context: Context, position: Int) =
            Intent(context, AddWordActivity::class.java)
                .putExtra(EXTRA_ID, position)
    }
}
