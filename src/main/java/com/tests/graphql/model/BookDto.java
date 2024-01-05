package com.tests.graphql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private String desc;
    private String author;
    private Double price;
    private Integer pages;

}
