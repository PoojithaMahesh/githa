package studentManagementSystemMain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;
import studentManagementSystemMain.dto.Student;

public class delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("sid"));
		
		StudentDao dao= new StudentDao();
		Student stu=dao.deleteStudent(id);
		PrintWriter printWriter=resp.getWriter();
		if(stu!=null) {
			printWriter.println("Delete Successfully");
		}else {
			printWriter.println("Student is not present to delete");
		}
	}

}
