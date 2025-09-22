package com.sancta.bible.verse

import com.sancta.bible.book.BibleCacheRepo
import com.sancta.bible.book.models.SectionModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import kotlin.random.Random

@RestController
@RequestMapping("/verses")
class VersesController @Autowired constructor(
    private val bibleCacheRepo: BibleCacheRepo
) {
    @GetMapping
    fun getDailyVerse(bibleId: String): SectionModel? {
        val bibleCache = bibleCacheRepo.findById(bibleId).orElse(null) ?: return null
        val books = bibleCache.bible
        if (books.isEmpty()) return null

        val dayOfYear = LocalDate.now().dayOfYear

        // Try until we find a non-empty section
        repeat(books.size * 2) { // safety limit to avoid infinite loop
            // Pick a random book
            val book = books.random()
            if (book.chapters.isEmpty()) return@repeat

            // Pick a random chapter
            val chapter = book.chapters.random()
            if (chapter.sections.isEmpty()) return@repeat

            // Pick a section based on dayOfYear
            val sectionIndex = dayOfYear % chapter.sections.size
            return chapter.sections[sectionIndex]
        }

        return null
    }
}