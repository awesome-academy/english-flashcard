package com.sunasterisk.englishflashcard.ui.learn

import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.local.TopicsLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAOlmpl
import com.sunasterisk.englishflashcard.ui.BaseFragment
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.fragment_learn.*
import java.lang.Exception

class LearnFragment : BaseFragment(), TopicContract.View {

    override val layoutResource get() = R.layout.fragment_learn
    private var topicAdapter = TopicAdapter()
    private var topicPresenter: TopicContract.Presenter? = null

    override fun initComponents() {
        initData()
        initRecyclerview()
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

    override fun showTopics(data: List<Topic>) {
        topicAdapter.updateData(data)
    }

    private fun initRecyclerview() = with(recyclerViewTopics) {
        adapter = topicAdapter
    }

    override fun showError(exception: Exception) {
        context?.toast(exception.message.toString())
    }
}
