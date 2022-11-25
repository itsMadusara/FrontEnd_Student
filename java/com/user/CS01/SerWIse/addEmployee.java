package com.user.CS01.SerWIse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class addEmployee extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String contact = req.getParameter("contact");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String BranchID = req.getParameter("BranchID");
        String date = req.getParameter("date");
        String role = req.getParameter("role");
        String employeeID = req.getParameter("employeeID");
        String password = req.getParameter("password");

//        PrintWriter out = resp.getWriter();

        String stmnt1 = "insert into serwise.employee (Employee_Id, First_Name, Last_Name, Address, Joined_Date, Phone_Number, Branch_Id) values (%s,'%s','%s','%s %s','%s','%s',%s);".formatted(employeeID, firstName, lastName, address, city, date, contact, BranchID);
//        out.println(stmnt1);
        String stmnt2 = "insert into serwise.login (email, pwd, user) values ('%s','%s','%s');".formatted(employeeID,password,role);

        try {
            Connection con = DatabaseConnection.initializeDatabase();
            Statement statement = con.createStatement();
            statement.executeUpdate(stmnt1);
            statement.executeUpdate(stmnt2);
            resp.sendRedirect("/GeneralManager/Employee/EmployeeHome.html");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
