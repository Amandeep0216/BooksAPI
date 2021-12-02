package com.books.bookapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Data

@Document(collection = "books")
public class Book {
    @Id
    String id;
    String bookname;
    String bookauthorname;
    String bookpublishdate;
    
}
