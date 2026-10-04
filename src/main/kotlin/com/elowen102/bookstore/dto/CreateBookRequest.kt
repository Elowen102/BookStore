package com.elowen102.bookstore.dto

import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class CreateBookRequest(
    @field:NotBlank(message = "标题不能为空")
    val title: String,
    val author: String? = null,
    val isbn: String? = null,
    val publishedAt: LocalDate? = null
)

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String?,
    val isbn: String?,
    val publishedAt: LocalDate?
)
