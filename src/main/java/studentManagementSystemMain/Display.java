package studentManagementSystemMain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManagementSystem.dao.StudentDao;
import studentManagementSystemMain.dto.Student;

public class Display extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("sid"));
		StudentDao dao=new StudentDao();
		Student stu=dao.selectStudent(id);
		if (stu!=null) {
	PrintWriter printWriter=resp.getWriter();
	printWriter.print(stu.getId());
	printWriter.print(stu.getEmail());
	printWriter.print(stu.getName());
	printWriter.print(stu.getPassword());
	}else {
		RequestDispatcher dispatcher=req.getRequestDispatcher("display.html");
		dispatcher.include(req, resp);
	}

}
}