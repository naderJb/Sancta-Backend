package com.sancta.base.extensions

import org.bson.types.ObjectId

fun String?.safe(defaultValue: String = "") = this ?: defaultValue
fun String?.toObjectId() = ObjectId(this)