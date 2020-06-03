package com.sunasterisk.englishflashcard.ui.quiz

import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.model.Quiz
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback
import java.util.*

class QuizPresenter(
    private val view: QuizContract.View,
    private val repository: DictionaryRepository
) : QuizContract.Presenter {

    private var arrExamDetail = mutableListOf<Quiz>()

    override fun getDataWordEnglish(idTopic: String) {
        repository.getAllDictionaries(idTopic, object : OnDataLoadedCallback<List<Dictionary>> {
            override fun onSuccess(data: List<Dictionary>) {
                view.showDataWordEnglish(mapperDictionaryToExamDetail(data))
            }

            override fun onFailed(exception: Exception) {
                view.showError(exception)
            }
        })
    }

    fun mapperDictionaryToExamDetail(data: List<Dictionary>): List<Quiz> {
        val randomWords = randomDictionary(data)
        val answers = randomWords.map { it.translate }
        for (i in randomWords.indices) {
            val question = randomWords[i].word
            val answerOfQuesiton = mutableListOf<String>()
            answerOfQuesiton.add(randomWords[i].translate)
            val temp = answers.toMutableList()
            temp.removeAt(i)
            temp.shuffle()
            answerOfQuesiton.add(temp[0])
            answerOfQuesiton.add(temp[1])
            answerOfQuesiton.add(temp[2])
            answerOfQuesiton.shuffle()
            val quiz = Quiz(
                question,
                answerOfQuesiton[0],
                answerOfQuesiton[1],
                answerOfQuesiton[2],
                answerOfQuesiton[3],
                randomWords[i].translate
            )
            arrExamDetail.add(quiz)
        }
        return arrExamDetail
    }
}

private fun randomDictionary(data: List<Dictionary>): List<Dictionary> {
    val arrayDictionary = data.toMutableList()
    val arrayExam = mutableListOf<Dictionary>()
    val rand = Random()
    while (arrayDictionary.size > 0 && arrayExam.size < 10) {
        val index = rand.nextInt(arrayDictionary.size)
        arrayExam.add(arrayDictionary[index])
        arrayDictionary.removeAt(index)
    }
    return arrayExam
}
