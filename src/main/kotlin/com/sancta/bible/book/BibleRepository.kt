package com.sancta.bible.book

import com.sancta.bible.book.models.BibleResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BibleRepository {
    @GET("bibles/{bibleID}/books")
    suspend fun getBibleById(
        @Path("bibleID") bookId: String,
        @Query(value = "include-chapters") includeChapters: Boolean = true,
        @Query(value = "include-chapters-and-sections") includeChaptersAndSections: Boolean = true,
    ): Response<BibleResponseModel>
}