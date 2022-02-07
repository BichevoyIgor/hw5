import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDao {
    private SessionFactory sFactory;

    public StudentDao(SessionFactory sFactory) {
        this.sFactory = sFactory;
    }

    public List<Student> findAllStudents() {
        Session session = sFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("from Student").getResultList();
        session.getTransaction().commit();
        return students;
    }

    public Student getStudent(int id) {
        Session session = sFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    public boolean removeStudent(int id) {
        Session session = sFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student == null) {
            session.getTransaction().commit();
            return false;
        } else {
            session.remove(student);
            session.getTransaction().commit();
            return true;
        }
    }

    public void createStudent(String name, String mark) {
        Session session = sFactory.getCurrentSession();
        session.beginTransaction();
        session.save(new Student(name, mark));
        session.getTransaction().commit();
    }

    public boolean renameStudent(int id, String name) {
        Student student = getStudent(id);
        if (student == null) {
            System.out.println("Студент с таким id не найден.");
            return false;
        } else {
            Session session = sFactory.getCurrentSession();
            session.beginTransaction();
            student.setName(name);
            session.update(student);
            session.getTransaction().commit();
            return true;
        }
    }

    public boolean changeMarkStudent(int id, String mark) {
        Student student = getStudent(id);
        if (student == null) {
            System.out.println("Студент с таким id не найден.");
            return false;
        } else {
            Session session = sFactory.getCurrentSession();
            session.beginTransaction();
            student.setMark(mark);
            session.update(student);
            session.getTransaction().commit();
            return true;
        }
    }
}
