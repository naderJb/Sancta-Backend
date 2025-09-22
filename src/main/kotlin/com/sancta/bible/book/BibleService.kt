package com.sancta.bible.book

import com.sancta.base.extensions.safe
import com.sancta.base.extensions.safeCall
import com.sancta.base.models.BaseResponse
import com.sancta.bible.book.models.BibleRedisCacheModel
import com.sancta.bible.book.models.BibleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BibleService @Autowired constructor(
    private val bibleRepository: BibleRepository,
    private val bibleCacheRepo: BibleCacheRepo
) {
    suspend fun getBibleById(
        bibleID: String
    ): ResponseEntity<BaseResponse<List<BibleResponse>>> {
        return safeCall {
            val bibleCache = bibleCacheRepo.findById(bibleID).orElse(null)
            val bibleList = bibleCache?.bible ?: bibleRepository.getBibleById(bibleID).body()?.books ?: emptyList()
            if (bibleCache == null) {
                bibleCacheRepo.save(
                    BibleRedisCacheModel(
                        bibleList.firstOrNull()?.bibleId.safe(),
                        bibleList
                    )
                )
            }
            bibleList
        }
    }
}