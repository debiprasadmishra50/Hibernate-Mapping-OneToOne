package demo.application.Bi_directional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class InstructorBiDirectionalDemo 
{
	public static void main(String[] args) 
	{
		// create a factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			Transaction tx = session.beginTransaction();
			
			// get the instructor detail object
			int id = 1; // will get the Instructor with id of 1 
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			// print instructor detail
			System.out.println("InstructorDetail : "+instructorDetail);
			
			// print associated instructor
			System.out.println("Instructor : "+instructorDetail.getInstructor());
			
			//commit transaction
			tx.commit();
			System.out.println("Done");
			
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("No Instructor Found");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
