package com.example.selfreferencingjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorId;
    private String authorName;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sponsor_id"
    )
    private Author sponsor;
/*
    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> sponsoredAuthors = new ArrayList<>();*/
}
