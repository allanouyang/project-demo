/*
 * This file is generated by jOOQ.
*/
package com.ouyang.project.jooq.domain;


import com.ouyang.project.jooq.domain.tables.Author;
import com.ouyang.project.jooq.domain.tables.Book;
import com.ouyang.project.jooq.domain.tables.BookStore;
import com.ouyang.project.jooq.domain.tables.BookToBookStore;
import com.ouyang.project.jooq.domain.tables.Language;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in jooq
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>jooq.author</code>.
     */
    public static final Author AUTHOR = com.ouyang.project.jooq.domain.tables.Author.AUTHOR;

    /**
     * The table <code>jooq.book</code>.
     */
    public static final Book BOOK = com.ouyang.project.jooq.domain.tables.Book.BOOK;

    /**
     * The table <code>jooq.book_store</code>.
     */
    public static final BookStore BOOK_STORE = com.ouyang.project.jooq.domain.tables.BookStore.BOOK_STORE;

    /**
     * The table <code>jooq.book_to_book_store</code>.
     */
    public static final BookToBookStore BOOK_TO_BOOK_STORE = com.ouyang.project.jooq.domain.tables.BookToBookStore.BOOK_TO_BOOK_STORE;

    /**
     * The table <code>jooq.language</code>.
     */
    public static final Language LANGUAGE = com.ouyang.project.jooq.domain.tables.Language.LANGUAGE;
}
