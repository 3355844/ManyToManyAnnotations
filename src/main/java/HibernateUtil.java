import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by user on 05.01.2017.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory ;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }catch (HibernateException ex){
                System.err.println("SessionFactory creation Failed " + ex);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
