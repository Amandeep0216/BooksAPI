package com.books.bookapi.Controller.Auth;

import java.util.List;

import com.books.bookapi.response;
import com.books.bookapi.DB.BookRepo;
import com.books.bookapi.Models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class BookController {

    @Autowired 
    BookRepo bookRepo;

    @PostMapping("/addBook")
    public response addBook(@RequestBody Book book){
        if(bookRepo.count()>0){
            List<Book>list =bookRepo.findAll();
            for (Book b : list) {
                if(b.getBookname().equals(book.getBookname())){
                    return new response(200, "alread exit",book);
                } 
            }
        }

        try{
            bookRepo.insert(book);
            return new response(200, "book inserted sucessfully", book);
        }catch(Exception e){
            return new response(404, "opps found some issue", e);
        }
    }

    @GetMapping("/getAllBook")
    public response getAllBook(){
        List<Book> list = bookRepo.findAll();     
        return new response(200, "match  found", list);
    }

    // @PostMapping("/getBook")
    // public response getBook(@RequestBody AuthBook authBook){
    //     if(bookRepo.count()>0){
    //         List<Book> list = bookRepo.findAll();
    //         for (Book bk : list) {
    //             if(bk.getBookname().equals(authBook.getName())){
    //                 return new response(200, "match found", bk);
    //             }   
    //         }
    //     }
    //     return new response(400, "match not found",authBook );
    // }
}
