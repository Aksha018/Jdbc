package com.chainsys.jdbc;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//@WebServlet("/DeleteUser")  
public class DeleteUser extends HttpServlet { 
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("user_id");  
        int id=Integer.parseInt(sid);  
       UserDao.delete(id);
        response.sendRedirect("ViewUser");  
    }  
}  