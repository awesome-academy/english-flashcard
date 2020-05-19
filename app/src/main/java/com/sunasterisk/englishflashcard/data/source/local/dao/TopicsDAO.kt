package com.sunasterisk.englishflashcard.data.source.local.dao

import com.sunasterisk.englishflashcard.data.model.Topic

interface TopicsDAO {
    fun getAllTopics(): List<Topic>
    fun addTopic(topic: Topic): Boolean
    fun deleteTopic(topicId: String): Boolean
}
