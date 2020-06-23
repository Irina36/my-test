package appmanager;

import model.BankAccount;
import model.Objects;
import model.DemoAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Objects<DemoAccount> demoAccount(String value) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<DemoAccount> result = session.createQuery("from DemoAccount where customer_id=" + value).list();
        session.getTransaction().commit();
        session.close();
        return new Objects(result);
    }
    public Objects<BankAccount> bankAccount(String value) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<BankAccount> result = session.createQuery("from BankAccount where customer_id=" + value).list();
        session.getTransaction().commit();
        session.close();
        return new Objects(result);
    }
}
