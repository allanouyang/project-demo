package com.ouyang.project.config;

import com.ouyang.project.jooq.domain.Jooq;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by ouyang on 2018/1/13.
 */
@Configuration
public class JooqTestConfig {
    @Bean
    public Jooq jooqSchema() {
        return Jooq.JOOQ;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/jooq");
        builder.username("root");
        builder.password("root");
        builder.driverClassName("com.mysql.jdbc.Driver");
        return builder.build();
    }

    @Bean
    public org.jooq.Configuration jooqConfiguration() {
        org.jooq.Configuration configuration = new DefaultConfiguration();
        configuration.set(dataSource());
        configuration.set(SQLDialect.MYSQL);
        return configuration;
    }
}
