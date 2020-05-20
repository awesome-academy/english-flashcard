package com.sunasterisk.englishflashcard.ui.learnandsearch

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.local.DictionaryLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.TopicsLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.DictionaryDAOlmpl
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAOlmpl
import com.sunasterisk.englishflashcard.ui.BaseFragment
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.fragment_learn.*
import java.lang.Exception

class LearnFragment : BaseFragment(), TopicContract.View, DictionaryContract.View {

    override val layoutResource get() = R.layout.fragment_learn
    private var topicAdapter = TopicAdapter()
    private var topicPresenter: TopicContract.Presenter? = null
    private var dictionaryAdapter = DictionaryAdapter()
    private var dictionaryPresenter: DictionaryContract.Presenter? = null

    override fun initComponents() {
        initData()
        initRecyclerviewTopics()
        searchDictionary()
        initRecyclerviewDictionary()

    }

    private fun initData() {
        context?.let {
            val topicsDao = TopicsDAOlmpl.getInstance(it)
            val localRepository: TopicsRepository = TopicsRepository.getInstance(
                local = TopicsLocalDataSource.getInstance(topicsDao)
            )
            topicPresenter = TopicPresenter(this, localRepository)
            topicPresenter?.getAllTopics()
        }
    }

    private fun initDataDictionary(nameEnglish: String) {
        context?.let {
            val dictionaryDao = DictionaryDAOlmpl.getInstance(it)
            val localRepository: DictionaryRepository = DictionaryRepository.getInstance(
                local = DictionaryLocalDataSource.getInstance(dictionaryDao)
            )
            dictionaryPresenter = DictionaryPresenter(this, localRepository)
            dictionaryPresenter?.getDictionaries(nameEnglish)
        }
    }

    override fun showTopics(data: List<Topic>) {
        topicAdapter.updateData(data)
    }

    private fun initRecyclerviewTopics() = with(recyclerViewTopics) {
        adapter = topicAdapter
    }

    private fun initRecyclerviewDictionary() = with(recyclerViewDictionary) {
        adapter = dictionaryAdapter
    }

    private fun searchDictionary() {

        editextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                initDataDictionary(s.toString())
                constraintLayoutSearch.visibility = View.VISIBLE
                constraintLayoutTopics.visibility = View.INVISIBLE
                if (editextSearch.text.toString().isEmpty()) {
                    constraintLayoutSearch.visibility = View.INVISIBLE
                    constraintLayoutTopics.visibility = View.VISIBLE
                }
            }

        })
    }

    override fun showDictionaries(data: List<Dictionary>) {
        dictionaryAdapter.updateData(data)
        if (data.size == 0) {
            linerLayoutNodata.visibility = View.VISIBLE
            recyclerViewDictionary.visibility = View.INVISIBLE
        } else {
            linerLayoutNodata.visibility = View.INVISIBLE
            recyclerViewDictionary.visibility = View.VISIBLE
        }
    }

    override fun showError(exception: Exception) {
        context?.toast(exception.message.toString())
    }
}
