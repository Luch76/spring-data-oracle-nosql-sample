package com.example;

import com.oracle.nosql.spring.data.core.mapping.NosqlId;
import com.oracle.nosql.spring.data.core.mapping.NosqlTable;
import lombok.Data;

@NosqlTable(tableName = "books")
@Data
public class Book {
    @NosqlId(generated = true)
    long id;
    String title;
    String author;
    double price;
}
