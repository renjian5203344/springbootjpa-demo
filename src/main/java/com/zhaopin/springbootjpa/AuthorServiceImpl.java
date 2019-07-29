package com.zhaopin.springbootjpa;


import com.zhaopin.springbootjpa.dataobject.Author;

import com.zhaopin.springbootjpa.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service//扫描注入service实现类
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Transactional
    @Override
    public Author updateAuthor() {
        Author author = new Author();
        author.setPhone("13801234567");
        author.setNickName("王晶");
        author.setSingnDate(new Date());
        authorRepository.save(author);
        Author author2 =authorRepository.findById((long) 1).get();
       author2.setNickName("百度");
        return  authorRepository.save(author2);
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return  authorRepository.save(author);
    }

    @Override
    public Author findAuthor(Long id) {
        return  authorRepository.findById(id).get();
    }

    @Override
    public void deleteAuthor(Long id) {
         authorRepository.deleteById(id);
    }
}
