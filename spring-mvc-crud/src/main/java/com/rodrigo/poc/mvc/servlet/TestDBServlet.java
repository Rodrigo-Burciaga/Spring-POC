package com.rodrigo.poc.mvc.servlet;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/DemoServlet")
public class TestDBServlet extends HttpServlet {

    @Value("${user}")
    private String user;

    @Value("${pass}")
    private String pass;

    @Value("${url}")
    private String url;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        String driver = "com.mysql.cj.jdbc.Driver";

        try (Connection connection = DriverManager.getConnection(url, user, pass);) {
            Class.forName(driver);
            PrintWriter out = response.getWriter();
            out.println("Connection to database: " + url);
            out.println("<br/>Success!");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}