package com.sunasterisk.englishflashcard.database

object SQLiteTable {

    const val TABLE_TOPICS = "Topic"
    const val COL_ID_TOPICS = "topicId"
    const val COL_NAME_TOPICS = "nameTopic"
    const val COL_IMG_TOPICS = "imgTopic"

    const val CREATE_TABLE_TOPICS = "CREATE TABLE $TABLE_TOPICS (" +
            "$COL_ID_TOPICS IDENTITY(1,1) PRIMARY KEY, " +
            "$COL_NAME_TOPICS TEXT, " +
            "$COL_IMG_TOPICS TEXT)"

    const val TABLE_DICTIONARY = "Dictionary"
    const val COL_ID_DICTIONARY = "dictionaryId"
    const val COL_TRANSLATE = "translate"
    const val COL_WORD = "word"
    const val COL_WORD_TYPE = "wordType"
    const val COL_SPELLING = "spelling"

    const val CREATE_TABLE_DICTIONARY = "CREATE TABLE $TABLE_DICTIONARY (" +
            "$COL_ID_DICTIONARY IDENTITY(1,1) PRIMARY KEY, " +
            "$COL_WORD TEXT, " +
            "$COL_WORD_TYPE TEXT, " +
            "$COL_SPELLING TEXT, " +
            "$COL_TRANSLATE TEXT, " +
            "$COL_ID_TOPICS INTEGER)"


    const val TABLE_WORDENGLISH = "WordEnglish"
    const val COL_ID_WORD = "wordId"

    const val CREATE_TABLE_WORDENGLISH = "CREATE TABLE $TABLE_WORDENGLISH (" +
            "$COL_ID_WORD IDENTITY(1,1) PRIMARY KEY, " +
            "$COL_WORD TEXT)"

    const val TABLE_WORDVIETNAMESE = "WordVietnamese"
    const val COL_ID_WORDVIETNAMESE = "wordvietnameseId"
    const val COL_WORD_VIETNAMESE = "wordVietnamese"

    const val CREATE_TABLE_WORDVIETNAMESE = "CREATE TABLE $TABLE_WORDVIETNAMESE (" +
            "$COL_ID_WORDVIETNAMESE IDENTITY(1,1) PRIMARY KEY, " +
            "$COL_WORD_VIETNAMESE TEXT)"

    const val TABLE_EXAM = "Exam"
    const val COL_ID_EXAM = "examId"
    const val COL_DATE_EXAM = "dateExam"
    const val COL_CORRECT_SENTENCES = "correctSentences"
    const val COL_WRONG_SENTENCES = "wrongSentences"
    const val COL_TOTAL_SCORE = "totalScore"

    const val CREATE_TABLE_EXAM = "CREATE TABLE $TABLE_EXAM (" +
            "$COL_ID_EXAM IDENTITY(1,1) PRIMARY KEY, " +
            "$COL_DATE_EXAM TEXT, " +
            "$COL_CORRECT_SENTENCES INTEGER, " +
            "$COL_WRONG_SENTENCES INTEGER, " +
            "$COL_TOTAL_SCORE INTEGER)"

    const val TABLE_EXAMDETAILS = "ExamDetails"
    const val COL_ID_EXAMDETAILS = "examdetailsId"
    const val COL_QUESTION = "question"
    const val COL_ANSWER_A = "answerA"
    const val COL_ANSWER_B = "answerB"
    const val COL_ANSWER_C = "answerC"
    const val COL_ANSWER_D = "answerD"
    const val COL_CHECK = "rightWrong"

    const val CREATE_TABLE_EXAMDETAILS = "CREATE TABLE $TABLE_EXAMDETAILS (" +
            "$COL_ID_EXAMDETAILS IDENTITY(1,1) PRIMARY KEY, " +
            "$COL_QUESTION TEXT, " +
            "$COL_ANSWER_A TEXT, " +
            "$COL_ANSWER_B TEXT, " +
            "$COL_ANSWER_C TEXT, " +
            "$COL_ANSWER_D TEXT, " +
            "$COL_CHECK TEXT, " +
            "$COL_ID_EXAM INTEGER)"
}
