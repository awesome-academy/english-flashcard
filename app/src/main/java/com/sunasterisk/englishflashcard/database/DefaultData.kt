package com.sunasterisk.englishflashcard.database

import android.content.Context
import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.source.local.dao.DictionaryDAOlmpl
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAOlmpl

object DefaultData {

    fun dataTopicDefault(context: Context?) {
        context?.let {
            val topicsDao = TopicsDAOlmpl.getInstance(it)
            topicsDao.apply {
                addTopic(
                    Topic(
                        1,
                        "Animals",
                        "https://ejoy-english.com/blog/wp-content/uploads/2018/12/ladybug-beetle-coccinellidae-insect-121472-400x267.jpeg"
                    )
                )
                addTopic(
                    Topic(
                        2,
                        "Plants",
                        "https://ejoy-english.com/blog/wp-content/uploads/2018/12/pexels-photo-1214405-300x400.jpeg"
                    )
                )
                addTopic(
                    Topic(
                        3,
                        "Fruits",
                        "https://ejoy-english.com/blog/wp-content/uploads/2018/12/food-fresh-fruit-isolated-42218-400x267.jpeg"
                    )
                )
                addTopic(
                    Topic(
                        4,
                        "Vegetables",
                        "https://ejoy-english.com/blog/wp-content/uploads/2019/01/celery.jpg"
                    )
                )
                addTopic(
                    Topic(
                        5,
                        "Landscape",
                        "https://ejoy-english.com/blog/wp-content/uploads/2019/01/pexels-photo-462162-400x225.jpeg"
                    )
                )
            }
        }
        dataWordDefault(context)
    }

    private fun dataWordDefault(context: Context?) {
        context?.let {
            val dictionaryDao = DictionaryDAOlmpl.getInstance(it)
            dictionaryDao.apply {
                addDictionary(
                    Dictionary(
                        word = "Bear",
                        wordType = "Noun",
                        spelling = "/bɛr/",
                        translate = "Con gấu",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Bird",
                        wordType = "Noun",
                        spelling = "/bɜrd/",
                        translate = "Con chim",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Cat ",
                        wordType = "Noun",
                        spelling = "/kæt/",
                        translate = "Con mèo",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Chicken",
                        wordType = "Noun",
                        spelling = "/ˈʧɪkən/",
                        translate = "Con gà",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Cow",
                        wordType = "Noun",
                        spelling = "/kaʊ/",
                        translate = "Con bò",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Elephant",
                        wordType = "Noun",
                        spelling = "/ˈɛləfənt/",
                        translate = "Con voi",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Fish",
                        wordType = "Noun",
                        spelling = "/fɪʃ/",
                        translate = "Con cá",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Goat",
                        wordType = "Noun",
                        spelling = "/goʊt/",
                        translate = "Con dê",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Lion",
                        wordType = "Noun",
                        spelling = "/ˈlaɪən/",
                        translate = "Sư tử",
                        topicsId = 1
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Mouse",
                        wordType = "Noun",
                        spelling = "/maʊs/",
                        translate = "Con chuột",
                        topicsId = 1
                    )
                )

                addDictionary(
                    Dictionary(
                        word = "Bloom",
                        wordType = "Verb",
                        spelling = "/blum/",
                        translate = "Nở hoa",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Branch",
                        wordType = "Noun",
                        spelling = "/brænʧ/",
                        translate = "Cành cây",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Bud",
                        wordType = "Noun",
                        spelling = "/bʌd/",
                        translate = "Chồi, búp cây",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Bush",
                        wordType = "Noun",
                        spelling = "/bʊʃ/",
                        translate = "Bụi cây",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Flower",
                        wordType = "Noun",
                        spelling = "/ˈflaʊər/",
                        translate = "Hoa",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Grass",
                        wordType = "Noun",
                        spelling = "/græs/",
                        translate = "Cỏ",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Grow",
                        wordType = "Verb",
                        spelling = "/groʊ/",
                        translate = "Mọc lên",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Leaf",
                        wordType = "Noun",
                        spelling = "/lif/",
                        translate = "Lá cây",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Root",
                        wordType = "Noun",
                        spelling = "/rut/",
                        translate = "Rễ cây",
                        topicsId = 2
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Trunk",
                        wordType = "Noun",
                        spelling = "/trʌŋk/",
                        translate = "Thân cây",
                        topicsId = 2
                    )
                )

                addDictionary(
                    Dictionary(
                        word = "Apple",
                        wordType = "Noun",
                        spelling = "/ˈæpəl/",
                        translate = "Quả táo",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Banana",
                        wordType = "Noun",
                        spelling = "/bəˈnænə/",
                        translate = "Quả chuối",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Cherry",
                        wordType = "Noun",
                        spelling = "/bʌd/",
                        translate = "Quả anh đào",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Grape",
                        wordType = "Noun",
                        spelling = "/greɪp/",
                        translate = "Quả nho",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Lemon",
                        wordType = "Noun",
                        spelling = "/ˈlɛmən/",
                        translate = "Quả chanh vàng",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Lime",
                        wordType = "Noun",
                        spelling = "/laɪm/",
                        translate = "Quả chanh xanh",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Mango",
                        wordType = "Noun",
                        spelling = "/groʊ/",
                        translate = "Quả xoài",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Orange",
                        wordType = "Noun",
                        spelling = "/ˈɔrənʤ/",
                        translate = "Quả cam",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Papaya",
                        wordType = "Noun",
                        spelling = "/pəˈpaɪə/",
                        translate = "Quả đu đủ",
                        topicsId = 3
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Peach",
                        wordType = "Noun",
                        spelling = "/piʧ/",
                        translate = "Quả đào",
                        topicsId = 3
                    )
                )

                addDictionary(
                    Dictionary(
                        word = "Bean",
                        wordType = "Noun",
                        spelling = "/bin/",
                        translate = "Đậu",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Bell pepper",
                        wordType = "Noun",
                        spelling = "/bɛl ˈpɛpər/",
                        translate = "Ớt chuông",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Broccoli",
                        wordType = "Noun",
                        spelling = "/ˈbrɑkəli/",
                        translate = "Súp lơ xanh",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Cabbage",
                        wordType = "Noun",
                        spelling = "/ˈkæbɪʤ/",
                        translate = "Bắp cải",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Carrot",
                        wordType = "Noun",
                        spelling = "/ˈkærət/",
                        translate = "Cà rốt",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Celery",
                        wordType = "Noun",
                        spelling = "/ˈsɛləri/",
                        translate = "Cần tây",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Chili",
                        wordType = "Noun",
                        spelling = "/ˈʧɪli/",
                        translate = "Ớt",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Corn",
                        wordType = "Noun",
                        spelling = "/kɔrn/",
                        translate = "Ngô",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Cucumber",
                        wordType = "Noun",
                        spelling = "/ˈkjukəmbər/",
                        translate = "Dưa chuột",
                        topicsId = 4
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Ginger",
                        wordType = "Noun",
                        spelling = "/ˈʤɪnʤər/",
                        translate = "Gừng",
                        topicsId = 4
                    )
                )

                addDictionary(
                    Dictionary(
                        word = "Cloud",
                        wordType = "Noun",
                        spelling = "/klaʊd/",
                        translate = "Mây",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Coast",
                        wordType = "Noun",
                        spelling = "/koʊst/",
                        translate = "Bờ biển",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Desert",
                        wordType = "Noun",
                        spelling = "/ˈdɛzɜrt/",
                        translate = "Sa mạc",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Forest",
                        wordType = "Noun",
                        spelling = "/ˈfɔrəst/",
                        translate = "Rừng",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Highland",
                        wordType = "Noun",
                        spelling = "/ˈhaɪlənd/",
                        translate = "Cao nguyên",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Hill",
                        wordType = "Noun",
                        spelling = "/hɪl/",
                        translate = "Đồi",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Horizon",
                        wordType = "Noun",
                        spelling = "/həˈraɪzən/",
                        translate = "Đường chân trờ",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Island",
                        wordType = "Noun",
                        spelling = "/ˈaɪlənd/",
                        translate = "Hòn đảo",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Lake",
                        wordType = "Noun",
                        spelling = "/leɪk/",
                        translate = "Hồ",
                        topicsId = 5
                    )
                )
                addDictionary(
                    Dictionary(
                        word = "Land",
                        wordType = "Noun",
                        spelling = "/lænd/",
                        translate = "Đất liền",
                        topicsId = 5
                    )
                )
            }
        }
    }
}
