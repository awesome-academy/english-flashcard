package com.sunasterisk.englishflashcard.ui.addtopic

import android.annotation.SuppressLint
import android.app.AlertDialog
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.local.TopicsLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAOlmpl
import com.sunasterisk.englishflashcard.ui.BaseFragment
import com.sunasterisk.englishflashcard.ui.addword.AddWordActivity
import com.sunasterisk.englishflashcard.ui.learn.TopicAdapter
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.dialog_custom.view.buttonAdd
import kotlinx.android.synthetic.main.dialog_custom.view.buttonExit
import kotlinx.android.synthetic.main.dialog_custom.view.editTextLinkImage
import kotlinx.android.synthetic.main.dialog_custom.view.editTextNameTopic
import kotlinx.android.synthetic.main.fragment_add_english.*
import java.lang.Exception

class AddTopicFragment : BaseFragment(), AddTopicContract.View, TopicAdapter.ClickListener {

    private var topicAdapter = TopicAdapter()
    private var presenter: AddTopicContract.Presenter? = null

    override val layoutResource get() = R.layout.fragment_add_english

    override fun initComponents() {
        initDataTopics()
        getAllTopics()
        addTopic()
    }

    private fun initDataTopics() {
        context?.let {
            val topicsDao = TopicsDAOlmpl.getInstance(it)
            val localRepository: TopicsRepository = TopicsRepository.getInstance(
                local = TopicsLocalDataSource.getInstance(topicsDao)
            )
            presenter = AddTopicPresenter(this, localRepository)
        }
    }

    private fun getAllTopics() {
        presenter?.getAllTopics()
        recyclerViewTopics.adapter = topicAdapter
    }

    @SuppressLint("InflateParams")
    private fun addTopic() {
        buttonAddTopic.setOnClickListener {
            showAddTopicDialog { name, image ->
                presenter?.addTopic(
                    Topic(0, name, image)
                )
                getAllTopics()
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun showAddTopicDialog(addClick: (String, String) -> Unit) {
        val dialog = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            .create()
        val view = layoutInflater.inflate(R.layout.dialog_custom, null).apply {
            buttonAdd.setOnClickListener {
                addClick(
                    editTextNameTopic.text.toString(),
                    editTextLinkImage.text.toString()
                )
                dialog.dismiss()
            }
            buttonExit.setOnClickListener {
                dialog.dismiss()
            }
        }
        dialog.setView(view)
        dialog.show()
    }

    override fun showTopics(topics: List<Topic>) {
        topicAdapter.apply {
            updateData(topics)
            setOnClickListener(this@AddTopicFragment)
        }
    }

    override fun notifyMessage(messageResId: Int) {
        context?.toast(getString(messageResId))
    }

    override fun showError(exception: Exception) {
        context?.toast(exception.message.toString())
    }

    override fun onItemClick(id: Int) {
        startActivity(context?.let { AddWordActivity.getIntent(it, id) })
    }
}
