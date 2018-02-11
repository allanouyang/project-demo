package com.ouyang.project.jooq;

import com.ouyang.project.jooq.domain.Jooq;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by ouyang on 2017/12/17.
 */
@Configuration
public class JooqDemoConfig {

//    @Autowired
//    private DataSource dataSource;

    @Bean
    public Jooq jooqSchema() {
        return Jooq.JOOQ;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public org.jooq.Configuration jooqConfiguration() {
        org.jooq.Configuration configuration = new DefaultConfiguration();
        configuration.set(dataSource());
        configuration.set(SQLDialect.MYSQL);
        return configuration;
    }

}

