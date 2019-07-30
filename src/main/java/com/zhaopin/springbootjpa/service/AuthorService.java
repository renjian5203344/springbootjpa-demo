package com.zhaopin.springbootjpa.service;


import com.zhaopin.springbootjpa.dataobject.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Author updateAuthor();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Author findAuthor(Long id);

    void  deleteAuthor(Long id);
}
