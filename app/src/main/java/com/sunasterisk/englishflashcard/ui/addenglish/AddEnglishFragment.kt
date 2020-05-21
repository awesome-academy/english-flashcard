package com.sunasterisk.englishflashcard.ui.addenglish

import android.annotation.SuppressLint
import android.app.AlertDialog
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.local.TopicsLocalDataSource
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAOlmpl
import com.sunasterisk.englishflashcard.ui.BaseFragment
import com.sunasterisk.englishflashcard.ui.learn.TopicAdapter
import com.sunasterisk.englishflashcard.ui.toast
import kotlinx.android.synthetic.main.dialog_custom.view.buttonAdd
import kotlinx.android.synthetic.main.dialog_custom.view.buttonExit
import kotlinx.android.synthetic.main.dialog_custom.view.editTextLinkImage
import kotlinx.android.synthetic.main.dialog_custom.view.editTextNameTopic
import kotlinx.android.synthetic.main.fragment_add_english.*
import java.lang.Exception

class AddEnglishFragment : BaseFragment(), AddEnglishContract.View {

    private var topicAdapter = TopicAdapter()
    private var presenter: AddEnglishContract.Presenter? = null

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
            presenter = AddEnglishPresenter(this, localRepository)
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
        topicAdapter.updateData(topics)
    }

    override fun notifyMessage(messageResId: Int) {
        context?.toast(getString(messageResId))
    }

    override fun showError(exception: Exception) {
        context?.toast(exception.message.toString())
    }
}
