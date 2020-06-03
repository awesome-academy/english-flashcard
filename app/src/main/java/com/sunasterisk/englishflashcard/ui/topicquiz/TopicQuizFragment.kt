package com.sunasterisk.englishflashcard.ui.topicquiz

import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.local.TopicsLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAOlmpl
import com.sunasterisk.englishflashcard.ui.BaseFragment
import com.sunasterisk.englishflashcard.ui.quiz.QuizActivity
import com.sunasterisk.englishflashcard.ui.learn.TopicAdapter
import com.sunasterisk.englishflashcard.ui.learn.TopicContract
import com.sunasterisk.englishflashcard.ui.learn.TopicPresenter
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.fragment_topic_quiz.recyclerViewTopicExam
import java.lang.Exception

class TopicQuizFragment : BaseFragment(), TopicContract.View, TopicAdapter.ClickListener {

    private var topicPresenter: TopicContract.Presenter? = null
    private var topicAdapter: TopicAdapter = TopicAdapter()

    override val layoutResource get() = R.layout.fragment_topic_quiz

    override fun initComponents() {
        initDataTopics()
    }

    private fun initDataTopics() {
        context?.let {
            val topicDao = TopicsDAOlmpl.getInstance(it)
            val localrepository = TopicsRepository.getInstance(
                local = TopicsLocalDataSource.getInstance(topicDao)
            )
            topicPresenter = TopicPresenter(this, localrepository)
            topicPresenter?.getAllTopics()
        }
    }

    override fun showTopics(topics: List<Topic>) {
        topicAdapter.apply {
            updateData(topics)
            setOnClickListener(this@TopicQuizFragment)
        }
        recyclerViewTopicExam.adapter = topicAdapter
    }

    override fun showError(exception: Exception) {
        context?.toast(exception.message.toString())
    }

    override fun onItemClick(id: Int) {
        startActivity(QuizActivity.getIntent(context!!, id))
    }
}
