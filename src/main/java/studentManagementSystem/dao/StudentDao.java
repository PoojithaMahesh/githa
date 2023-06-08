package studentManagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentManagementSystemMain.dto.Student;

public class StudentDao {
	
	public EntityManager getmanager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
		
	}
	
	public Student signUpStudent(Student student) {
		EntityManager em=getmanager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		System.out.println("Student details has been saved");
		return student ;
	}
	
//	public void loginStudent (String email, String password) {
//		EntityManager em=getmanager();
//		Query query=em.createQuery("select a from Student a where a.email=?1");
//		
//		query.setParameter(1, email);
//		Student stu=(Student) query.getSingleResult();
//		
//		if(stu!=null) {
//			boolean value=stu.getPassword().equals(password);
//			if(value) {
//				System.out.println("Login successfull");
//			}else {
//				System.out.println("Password is wrong");
//			}
//		}
	
	
	// login student if email and password is matched
	
	
		public Student loginStudent (String email, String password) {
			EntityManager em=getmanager();
			Query query=em.createQuery("select a from Student a");
			
			List<Student>list=query.getResultList();
           boolean value =false;
			
			for(Student student : list) {
				if(student.getEmail().equals(email)) {
					Query query1=em.createQuery("select a from Student a where a.email=?1");

					query1.setParameter(1, email);
					Student studb=(Student) query1.getSingleResult();
					
					return studb;

				} 	
					return null;
				
			}
			return null;
			
			
		}
		

		
	
	public Student updateStudent(int id, String name) {
		EntityManager em=getmanager();
		Student stu=em.find(Student.class, id);
		if(stu!=null) {
			EntityTransaction et=em.getTransaction();
			et.begin();
			stu.setName(name);
			em.merge(stu);
			et.commit();
			
			return stu;
			
		}else {
			return null;
		}
		
		
		

		}
	
	public Student deleteStudent(int id) {
		EntityManager em=getmanager();
		Student stu=em.find(Student.class, id);
		if(stu!=null) {
			EntityTransaction et=em.getTransaction();
			et.begin();
			
			em.remove(stu);
			et.commit();
			
			return stu;
			
		}else {
			return null;

	}
	


}

	public Student selectStudent(int id) {
		EntityManager em=getmanager();
		Student stu=em.find(Student.class, id);
		if (stu!=null) {
			
			return stu;
		}else {
			return null;
		}
			

	}
	
	public List<Student> getAllStudents(){
		
		EntityManager em=getmanager();

		Query query=em.createQuery("select a from Student a");
		List<Student> list=query.getResultList();
		
		return list;
				
	}

	public Student getStudentByEmail(String email) {
		EntityManager em=getmanager();

		Query query=em.createQuery("select a from Student a where a.email=?1");
		query.setParameter(1, email);
		Student stu=(Student) query.getSingleResult();
		
		return stu;
		
	}
}

	
