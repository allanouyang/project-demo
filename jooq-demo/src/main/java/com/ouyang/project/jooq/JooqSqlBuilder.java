package com.ouyang.project.jooq;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ouyang.project.jooq.domain.tables.Author.AUTHOR;
import static com.ouyang.project.jooq.domain.tables.Book.BOOK;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

/**
 * Created by ouyang on 2017/12/17.
 */
@Service
public class JooqSqlBuilder {

    @Autowired
    private Configuration configuration;

    public String generateSimpleSql() {
//        Configuration conf = new DefaultConfiguration();
//        Settings settings = new Settings();
        DSLContext create = DSL.using(SQLDialect.MYSQL);
        String sql = create.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                .from(table("BOOK"))
                .join(table("AUTHOR"))
                .on(field("BOOK.AUTHOR_ID").eq(field("AUTHOR.ID")))
                .where(field("BOOK.PUBLISHED_IN").eq(1948))
                .getSQL();
        create.close();
        return sql;
    }

    public String generateSimpleSql2() {
        configuration.settings().setRenderFormatted(true);
        configuration.settings().setRenderCatalog(false);
        configuration.settings().withRenderSchema(false);
        DSLContext create = DSL.using(configuration);
        String sql = create.select(BOOK.TITLE, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .from(BOOK)
                .join(AUTHOR)
                .on((BOOK.AUTHOR_ID).eq(AUTHOR.ID))
                .where(BOOK.PUBLISHED_IN.eq(1948L))
                .getSQL();
        create.close();
        return sql;
    }

    public String generateRuntimeSql() {
        Settings settings = new Settings()
                .withRenderMapping(new RenderMapping()
                        .withSchemata(
                                new MappedSchema().withInput("jooq")
                                        .withOutput("MY_BOOK_WORLD")));
        //default style is RenderNameStyle.QUOTED
        settings.withRenderNameStyle(RenderNameStyle.UPPER);
        //default style is RenderKeywordStyle.AS_IS
        settings.withRenderKeywordStyle(RenderKeywordStyle.UPPER);
//        settings.withStatementType(StatementType.STATIC_STATEMENT);
//        settings.withExecuteLogging(false);
        configuration.set(settings);
        DSLContext create = DSL.using(configuration);
        return create.selectFrom(AUTHOR).where(AUTHOR.ID.eq(1L)).getSQL();
    }
}
