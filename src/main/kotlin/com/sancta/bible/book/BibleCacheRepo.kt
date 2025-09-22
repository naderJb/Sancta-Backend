package com.sancta.bible.book

import com.sancta.bible.book.models.BibleRedisCacheModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BibleCacheRepo : MongoRepository<BibleRedisCacheModel, String>