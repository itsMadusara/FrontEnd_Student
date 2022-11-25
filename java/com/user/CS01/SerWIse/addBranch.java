package com.user.CS01.SerWIse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class addBranch extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String branchID = req.getParameter("branchID");
        String location = req.getParameter("location");
        String address = req.getParameter("address");
        String noOfSlotes = req.getParameter("noOfSlots");
        String stmnt = "insert into serwise.branch (Branch_Id, Number_of_Slots, Location) values (%s,%s,'%s %s');".formatted(branchID, noOfSlotes, address, location);
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            Statement statement = con.createStatement();
            statement.executeUpdate(stmnt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
