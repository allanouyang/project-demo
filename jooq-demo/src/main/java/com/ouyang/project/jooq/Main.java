package com.ouyang.project.jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ouyang on 2017/10/18.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        String userName = "zxyadmin";
//        String p = "dreamtech";
//        String url = "jdbc:mysql://116.62.33.79:3306/test";
//        // Connection is the only JDBC resource that we need
//        // PreparedStatement and ResultSet are handled by jOOQ, internally
//        try (Connection conn = DriverManager.getConnection(url, userName, p)) {
//            // ...
//            Settings settings = new Settings();
//            settings.setStatementType(StatementType.STATIC_STATEMENT);
//            DSLContext create = DSL.using(conn, SQLDialect.MYSQL, settings);
////            String sql = create.select().from("TEST_CANAL").getQuery().getSQL();
////            System.out.println("sql:"+sql+".......");
//            Result<Record> result = create.select().from("TEST_CANAL").fetch();
////            result.set(2, "test_canal1...");
//
//            System.out.println(result.size());
////            UpdatableRecord record = (UpdatableRecord)create.newRecord(new TableImpl<Record>("TEST_CANAL"), new TestCanal(5));
////            record.changed(1, false);
////            record.changed(2, false);
////            record.store();
//            create.close();
//        }
//
//        // For the sake of this tutorial, let's keep exception handling simple
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static class TestCanal {
        private Integer id;
        private String name;
        public TestCanal() {

        }

        public TestCanal(Integer id) {
            this.id = id;
        }

        public TestCanal(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
