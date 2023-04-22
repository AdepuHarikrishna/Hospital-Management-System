package com.hms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.User;
import com.model.Intr.UserIntr;

@WebServlet("/")
public class UserSrv extends HttpServlet {
	UserIntr ui;
	public void init(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("patient-cfg.xml");
	   ui =  (UserIntr) ctx.getBean("udao");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		String action = request.getServletPath();
		
		try{
			switch (action){
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
				default:
					listUser(request, response);
					break;
			
			}
		}catch (Exception ex){
			throw new ServletException(ex);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> listUser = ui.getAllUsers();
		System.out.println(listUser);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
   Map existingUser = ui.selectUser(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	request.setAttribute("user", existingUser);
	dispatcher.forward(request, response);
} 
private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name =request.getParameter("name");
	String bloodgroup = request.getParameter("email");
	String disease = request.getParameter("country");
	
	User newUser = new User(name, bloodgroup, disease);
	ui.insertUser(newUser);
	response.sendRedirect("list");

}
private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String bloodgroup = request.getParameter("email");
	String disease = request.getParameter("country");
	
	User u = new User(id , name , bloodgroup,disease);
	ui.updateUser(u);
	response.sendRedirect("list");
}
private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	ui.deleteUser(id);
	response.sendRedirect("list");
}
}
