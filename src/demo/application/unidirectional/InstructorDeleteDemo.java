package demo.application.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class InstructorDeleteDemo 
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
			
			// get the instructor by their primary key / id
			int id = 2; // Id 2 data will be deleted
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Found Instructor : "+instructor);
			
			// Delete the instructors
			if(instructor != null) {
				System.out.println("Deleting: "+instructor);
				session.delete(instructor); // Note: This will also delete associated "details" object in the instructor_detail table because of the Cascade
			}
				
			//commit transaction
			tx.commit();
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
		
	}
}
