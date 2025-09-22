package com.sancta.base.models

data class BaseResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val error: String? = null
)