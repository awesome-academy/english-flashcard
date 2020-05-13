package com.sunasterisk.englishflashcard.database

object SQLiteTable {

    var TABLE_TOPICS = "Topic"
    var COL_ID_TOPICS = "topicId"
    var COL_NAME_TOPICS = "nameTopic"
    var COL_IMG_TOPICS = "imgTopic"

    var CREATE_TABLE_TOPICS = String.format(
        "CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT, %s TEXT)",
        TABLE_TOPICS, COL_ID_TOPICS, COL_NAME_TOPICS, COL_IMG_TOPICS
    )

    var TABLE_DICTIONARY = "Dictionary"
    var COL_ID_DICTIONARY = "dictionaryId"
    var COL_TRANSLATE = "translate"
    var COL_WORD = "word"
    var COL_WORD_TYPE = "wordType"
    var COL_SPELLING = "spelling"

    var CREATE_TABLE_DICTIONARY = String.format(
        "CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT ,%s INTEGER)",
        TABLE_DICTIONARY, COL_ID_DICTIONARY, COL_WORD, COL_WORD_TYPE, COL_SPELLING,
        COL_TRANSLATE, COL_ID_TOPICS
    )

    private var TABLE_WORDENGLISH = "WordEnglish"
    private var COL_ID_WORD = "wordId"

    var CREATE_TABLE_WORDENGLISH = String.format(
        "CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT)",
        TABLE_WORDENGLISH, COL_ID_WORD, COL_WORD
    )

    private var TABLE_WORDVIETNAMESE = "WordVietnamese"
    private var COL_ID_WORDVIETNAMESE = "wordvietnameseId"
    private var COL_WORD_VIETNAMESE = "wordVietnamese"

    var CREATE_TABLE_WORDVIETNAMESE = String.format(
        "CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT)",
        TABLE_WORDVIETNAMESE, COL_ID_WORDVIETNAMESE, COL_WORD_VIETNAMESE
    )

    var TABLE_EXAM = "Exam"
    var COL_ID_EXAM = "examId"
    var COL_DATE_EXAM = "dateExam"
    var COL_CORRECT_SENTENCES = "correctSentences"
    var COL_WRONG_SENTENCES = "wrongSentences"
    var COL_TOTAL_SCORE = "totalScore"

    var CREATE_TABLE_EXAM = String.format(
        "CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT, %s INTEGER, %s INTEGER, %s INTEGER)",
        TABLE_EXAM, COL_ID_EXAM, COL_DATE_EXAM, COL_CORRECT_SENTENCES, COL_WRONG_SENTENCES,
        COL_TOTAL_SCORE
    )

    var TABLE_EXAMDETAILS = "ExamDetails"
    var COL_ID_EXAMDETAILS = "examdetailsId"
    var COL_QUESTION = "question"
    var COL_ANSWER_A = "answerA"
    var COL_ANSWER_B = "answerB"
    var COL_ANSWER_C = "answerC"
    var COL_ANSWER_D = "answerD"
    var COL_CHECK = "check"

    var CREATE_TABLE_EXAMDETAILS = String.format(
        "CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s INTEGER)",
        TABLE_EXAMDETAILS, COL_ID_EXAMDETAILS, COL_QUESTION, COL_ANSWER_A, COL_ANSWER_B,
        COL_ANSWER_C, COL_ANSWER_D, COL_CHECK, COL_ID_EXAM
    )
}
