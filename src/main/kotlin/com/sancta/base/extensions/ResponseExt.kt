package com.sancta.base.extensions

import com.sancta.base.models.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

inline fun <T> safeCall(
    block: () -> T
): ResponseEntity<BaseResponse<T>> {
    return try {
        val result = block()
        ResponseEntity.ok(BaseResponse(success = true, data = result))
    } catch (e: IllegalArgumentException) {
        ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(BaseResponse(success = false, error = e.message))
    } catch (e: NoSuchElementException) {
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(BaseResponse(success = false, error = e.message ?: "Not found"))
    } catch (e: Exception) {
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse(success = false, error = e.message ?: "Internal error"))
    }
}