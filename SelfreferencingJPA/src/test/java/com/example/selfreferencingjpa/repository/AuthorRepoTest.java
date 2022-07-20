package com.example.selfreferencingjpa.repository;

import com.example.selfreferencingjpa.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepoTest {

    @Autowired
    private AuthorRepo authorRepo;

    @Test
    public void saveAuthor(){

        Author author2 = Author.builder()
                .authorName("Zahin")
                .build();
        Author author3 = Author.builder()
                .authorName("Nila")
                .sponsor(author2)
                .build();
       // author2.getSponsoredAuthors().add(author3);
        authorRepo.save(author3);
    }


}