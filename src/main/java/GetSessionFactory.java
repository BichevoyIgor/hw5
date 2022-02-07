import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetSessionFactory {
    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
