package com.sancta.bible.book

import com.sancta.base.models.BaseResponse
import com.sancta.bible.book.models.BibleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bible")
class BibleController @Autowired constructor(
    private val bibleService: BibleService
) {
    @GetMapping
    suspend fun getBooks(
        @RequestParam(required = true) bibleID: String,
    ): ResponseEntity<BaseResponse<List<BibleResponse>>> = bibleService.getBibleById(bibleID)
}