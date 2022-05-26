/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import helper.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author trunghuynh
 */
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        List<Product> list = new ArrayList<>();
        int i = 1;
        String option = (String) request.getAttribute("option");     
        String sql;
        PreparedStatement preparedStatement;
        try {
            if (option != null) {
                sql = "select * from product where category = '"+option+"'";                              
            } else {
                sql = "select * from product";   
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet result = (ResultSet) preparedStatement.executeQuery(sql);
            while (result.next()) {
                Product p = new Product();
                p.setStt(i);
                p.setId(result.getInt("id"));
                p.setCategory(result.getString("category"));
                p.setName(result.getString("name"));
                p.setPrice(result.getDouble("price"));
                i++;
                list.add(p);
            }
            request.setAttribute("list", list);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            pool.freeConnection(connection);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
