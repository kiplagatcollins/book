package com.coki.book.controller;

import com.coki.book.model.Book;
import com.coki.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    private List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    private  Book getBook(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("books/{bookId}")
    private void deleteBook(@PathVariable("bookId") int bookId){
        bookService.delete(bookId);
    }

    @PostMapping("/books")
    private Book saveBook(@RequestBody Book book){
        Book savedBook = bookService.saveOrUpdate(book);
        return  savedBook;

    }
    @PutMapping("/books/{bookId}")
    private Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        Book b= bookService.getBookById(bookId);
        b.setBookName(book.getBookName());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        Book savedBook = bookService.saveOrUpdate(b);
        return  savedBook;
    }



}
