package com.elowen102.bookstore.service

import com.elowen102.bookstore.dto.BookResponse
import com.elowen102.bookstore.dto.CreateBookRequest
import com.elowen102.bookstore.model.Book
import com.elowen102.bookstore.repository.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun findAll(): List<BookResponse> =
        bookRepository.findAll().map { toResponse(it) }

    fun findById(id: Long): BookResponse? =
        bookRepository.findByIdOrNull(id)?.let { toResponse(it) }

    @Transactional
    fun create(request: CreateBookRequest): BookResponse {
        val book = Book(
            title = request.title,
            author = request.author,
            isbn = request.isbn,
            publishedAt = request.publishedAt
        )
        return toResponse(bookRepository.save(book))
    }

    @Transactional
    fun update(id: Long, request: CreateBookRequest): BookResponse? {
        val existing = bookRepository.findByIdOrNull(id) ?: return null
        existing.title = request.title
        existing.author = request.author
        existing.isbn = request.isbn
        existing.publishedAt = request.publishedAt
        return toResponse(bookRepository.save(existing))
    }

    @Transactional
    fun delete(id: Long): Boolean {
        if (!bookRepository.existsById(id)) {
            return false
        }
        bookRepository.deleteById(id)
        return true
    }

    private fun toResponse(book: Book): BookResponse =
        BookResponse(
            id = book.id,
            title = book.title,
            author = book.author,
            isbn = book.isbn,
            publishedAt = book.publishedAt
        )
}
