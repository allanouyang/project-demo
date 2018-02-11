package com.ouyang.project.jooq;

import org.jooq.*;
import org.jooq.Configuration;
import org.jooq.impl.DSL;
import org.jooq.util.jaxb.*;
import org.jooq.util.jaxb.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.ouyang.project.jooq.domain.tables.Book.BOOK;
import static com.ouyang.project.jooq.domain.tables.Author.AUTHOR;


/**
 * Created by ouyang on 2018/1/12.
 */
@Service
public class JooqExecutor {

    @Autowired
    private Configuration configuration;

    public Result<Record3<String, String, String>> simpleSelect() {
        DSLContext create = DSL.using(configuration);
        Result<Record3<String, String, String>> result =
                create.select(BOOK.TITLE, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                        .from(BOOK)
                        .join(AUTHOR)
                        .on(BOOK.AUTHOR_ID.eq(AUTHOR.ID))
                        .where(BOOK.PUBLISHED_IN.eq(1948L))
                        .fetch();
        create.close();
        return result;
    }

    public void simpleSqlSelect() {
        DSLContext create = DSL.using(configuration);

        String sql = "select schema_name, default_character_set_name from information_schema.schemata order by schema_name";
        create.fetch(sql).map(rs -> new Schema(
                rs.getValue("schema_name", String.class),
                rs.getValue("default_character_set_name", String.class)
        )).forEach(System.out::println);
        create.close();
    }

    public void useSelectQuery() {
        DSLContext create = DSL.using(configuration);
        SelectQuery<Record> query = create.selectQuery();
        query.addSelect(BOOK.TITLE);
        query.addFrom(AUTHOR);
        query.addJoin(BOOK, BOOK.AUTHOR_ID.eq(AUTHOR.ID));
        Result<Record> result = query.fetch();
        result.map(r -> r.getValue(BOOK.TITLE))
                .forEach(r -> System.out.println(r));
        create.close();
    }

    public void useSelectStep() {
        DSLContext create = DSL.using(configuration);
        SelectFinalStep select = create.select(BOOK.TITLE).from(AUTHOR);
        SelectQuery query = select.getQuery();
        query.addJoin(BOOK, BOOK.AUTHOR_ID.eq(AUTHOR.ID));
        Result<Record> result = query.fetch();
        result.map(r -> r.getValue(BOOK.TITLE))
                .forEach(r -> System.out.println(r));
        create.close();
    }

    public void customExecute(JooqExecutorCallback callback) {
        DSLContext create = DSL.using(configuration);
        callback.execute(create);
        create.close();
    }

    private static class Schema {
        public String schemaName;
        public String characterSet;
        public Schema(String schemaName, String characterSet) {
            this.schemaName = schemaName;
            this.characterSet = characterSet;
        }

        @Override
        public String toString() {
            return "schemaName:"+this.schemaName+", characterSet:"+characterSet;
        }
    }


}
