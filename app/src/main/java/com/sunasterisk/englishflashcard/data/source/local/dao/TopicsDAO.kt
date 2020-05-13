package com.sunasterisk.englishflashcard.data.source.local.dao

import com.sunasterisk.englishflashcard.data.model.Topics

interface TopicsDAO {
    fun getAllTopics(): List<Topics>
    fun addTopic(topic: Topics): Boolean
    fun deleteTopic(topicId: String): Boolean
}
