package com.elowen102.bookstore.controller

import com.elowen102.bookstore.dto.CreateBookRequest
import com.elowen102.bookstore.service.BookService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class BookController(
    private val bookService: BookService
) {

    @GetMapping("/books")
    fun listBooks(): ResponseEntity<Any> =
        ResponseEntity.ok(bookService.findAll())

    @GetMapping("/books/{id}")
    fun getBook(@PathVariable id: Long): ResponseEntity<Any> {
        val book = bookService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(book)
    }

    @PostMapping("/books")
    fun createBook(@RequestBody @Valid request: CreateBookRequest): ResponseEntity<Any> =
        ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(request))

    @PutMapping("/books/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody @Valid request: CreateBookRequest): ResponseEntity<Any> {
        val updated = bookService.update(id, request) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/books/{id}")
    fun deleteBook(@PathVariable id: Long): ResponseEntity<Any> {
        val deleted = bookService.delete(id)
        return if (deleted) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}
