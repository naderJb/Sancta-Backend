package com.sancta.bible.book.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BibleResponseModel(
    @SerializedName("data")
    val books: List<BibleResponse>
) : Serializable

data class BibleResponse(
    @SerializedName("id") val id: String,
    @SerializedName("bibleId") val bibleId: String,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("name") val name: String,
    @SerializedName("nameLong") val nameLong: String,
    @SerializedName("chapters") val chapters: List<ChapterModel>,
) : Serializable

data class ChapterModel(
    @SerializedName("id") val id: String,
    @SerializedName("bibleId") val bibleId: String,
    @SerializedName("bookId") val bookId: String,
    @SerializedName("number") val number: String,
    @SerializedName("position") val position: Int,
    @SerializedName("sections") val sections: List<SectionModel>,
) : Serializable

data class SectionModel(
    @SerializedName("id") val id: String,
    @SerializedName("bibleId") val bibleId: String,
    @SerializedName("title") val title: String,
    @SerializedName("firstVerseId") val firstVerseId: String,
    @SerializedName("lastVerseId") val lastVerseId: String,
    @SerializedName("firstVerseOrgId") val firstVerseOrgId: String,
    @SerializedName("lastVerseOrgId") val lastVerseOrgId: String,
) : Serializable