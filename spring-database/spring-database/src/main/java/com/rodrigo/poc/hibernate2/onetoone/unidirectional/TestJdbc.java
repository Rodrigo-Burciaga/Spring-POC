package com.rodrigo.poc.hibernate2.onetoone.unidirectional;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String ... args){
        String jdbcUrl = "jdbc:mysql://172.17.0.2:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "root";
        String password = "31193";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println(conn);
            System.out.println("Successful connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
