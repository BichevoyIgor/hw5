import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();
        StudentDao studentDao = new StudentDao(sessionFactory);
        System.out.println(studentDao.findAllStudents());


    }
}
