package com.ouyang.project.jooq;

import com.ouyang.project.config.JooqTestConfig;
import com.ouyang.project.jooq.domain.tables.records.BookRecord;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.Select;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.ouyang.project.jooq.domain.tables.Author.AUTHOR;
import static com.ouyang.project.jooq.domain.tables.Book.BOOK;
import static com.ouyang.project.jooq.domain.tables.Language.LANGUAGE;

/**
 * Created by ouyang on 2018/1/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JooqTestConfig.class, JooqExecutor.class})
public class JooqExecutorTest {

    @Autowired
    private JooqExecutor executor;

    @Test
    public void testSimpleSelect() {
        Result<Record3<String, String, String>> result = executor.simpleSelect();
        Record3<String, String, String> record3 = result.get(0);
        Assert.assertEquals(record3.getValue(BOOK.TITLE), "1984");
        Assert.assertEquals(record3.getValue(AUTHOR.FIRST_NAME), "George");
        Assert.assertEquals(record3.getValue(AUTHOR.LAST_NAME), "Orwell");
    }

    @Test
    public void testSimpleSqlSelect() {
        executor.simpleSqlSelect();
    }

    @Test
    public void testUseSelectQuery() {
        executor.useSelectQuery();
    }

    @Test
    public void testUseSelectStep() {
        executor.useSelectStep();
    }

    private JooqExecutorCallback complexSqlQuery() {
        return (ctx -> {
            Select<Record3<String, String, Integer>> select = ctx.select(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, DSL.count())
                    .from(AUTHOR)
                    .join(BOOK).on(BOOK.AUTHOR_ID.eq(AUTHOR.ID))
                    .join(LANGUAGE).on(LANGUAGE.ID.eq(BOOK.LANGUAGE_ID))
            .where(LANGUAGE.CD.eq("de"))
            .and(BOOK.PUBLISHED_IN.ge(1990L))
            .groupBy(AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
            .having(DSL.count().le(5))
            .orderBy(AUTHOR.LAST_NAME.asc().nullsFirst())
            .limit(1).offset(0)
            .forUpdate();
            System.out.println(select.getSQL());
            select.fetch().forEach(r -> {
                System.out.println(r.getValue(AUTHOR.FIRST_NAME));
                System.out.println(r.getValue(AUTHOR.LAST_NAME));
                System.out.println(r.getValue(2));
            });
        });
    }

    private JooqExecutorCallback selectSingleTable() {
        return (ctx -> {
            BookRecord record = ctx.selectFrom(BOOK)
//                    .where(BOOK.LANGUAGE_ID.eq(1L))
                    .orderBy(BOOK.TITLE)
                    .fetchAny();
            System.out.println(record.getAuthorId());
        });
    }

    @Test
    public void testCustomExecute() {
        executor.customExecute(complexSqlQuery());
//        executor.customExecute(selectSingleTable());
    }

}
