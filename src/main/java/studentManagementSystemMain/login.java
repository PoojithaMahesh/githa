package studentManagementSystemMain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;
import studentManagementSystemMain.dto.Student;

public class login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	// login student though email	and should match the password
		String email=req.getParameter("semail");
		String password=req.getParameter("spwd");
		
		StudentDao dao= new StudentDao();
//		dao.loginStudent(email, password);
		
//		Student stu=dao.loginStudent(email, password);
//
//		if(stu!=null) {
//			if(stu.getPassword().equals(password)) {
//				PrintWriter printWriter=resp.getWriter();
//				printWriter.println("Login Successfull");
//
//			
//		}else {
//			PrintWriter printWriter=resp.getWriter();
//			printWriter.println("Email or Password is incorrect");
//			
//		}
//			
//		}else {
//
//			PrintWriter printWriter=resp.getWriter();
//		printWriter.println("Student does not exist");
//		}
//	}
	
	
		
		List<Student> list=dao.getAllStudents();  //having return type and storing in the list of student
		boolean value=false;  //stablishing value
		for(Student stu : list) {  //iterating the student
			if (stu.getEmail().equals(email)) {
				value=true;
				break;
			}
		} 
		if(value==false) {
			// email is not present
			
//			PrintWriter printWriter=resp.getWriter();
//			printWriter.println("Email does not exit");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
			
		}else {
			// email is present
			Student stu= dao.getStudentByEmail(email);
			
			if(stu.getPassword().equals(password)) {
			
//			PrintWriter printWriter=resp.getWriter();
//			printWriter.println("Login Successfull");
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.html");
				dispatcher.forward(req, resp);
				
		}else {
//			PrintWriter printWriter=resp.getWriter();
//			printWriter.println("Login Failure");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}


		}
	}

	

}
