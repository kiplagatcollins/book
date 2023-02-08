package com.coki.book.service;

import com.coki.book.model.Book;
import com.coki.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return  books;
    }

    public Book getBookById(int bookId) {
        Book book=new Book();
        if(bookRepository.findById(bookId).isPresent()){
         book=   bookRepository.findById(bookId).get();
        }
        return book;
    }

    public void delete(int bookId) {
         bookRepository.deleteById(bookId);
    }

    public Book saveOrUpdate(Book book) {
        return  bookRepository.save(book);
    }
}
