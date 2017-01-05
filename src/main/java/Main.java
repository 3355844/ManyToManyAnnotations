import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 05.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Set<Course> courses = new HashSet<Course>();
            courses.add(new Course("Maths"));
            courses.add(new Course("Java"));
            Student student1 = new Student("Andrei", courses);
            Student student2 = new Student("Sergei", courses);

            session.save(student1);
            session.save(student2);
            transaction.commit();
        }catch (HibernateException ex){
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
           HibernateUtil.shutdown();
        }
    }
}
