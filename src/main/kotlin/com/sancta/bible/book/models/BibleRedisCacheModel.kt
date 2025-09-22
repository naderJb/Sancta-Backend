package com.sancta.bible.book.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document(collection = "bible")
data class BibleRedisCacheModel(
    @Id
    val bibleId: String,
    val bible: List<BibleResponse>
) : Serializable