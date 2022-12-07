import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.swing.*;

public class hibernateFile {
    private static SessionFactory sessionFactory;

    static {

        try {

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable se) {
            JOptionPane.showMessageDialog(null, "Error de auto cerrable de hibernate  ", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, se, "Error", JOptionPane.ERROR_MESSAGE);


        }


    }

    public static Session getSession() {


        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        final Session session = getSession();
        try {

            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {

                final String entityName = entityType.getName();
                final Query query = session.createQuery("from" + entityName);
            }

        } catch (HibernateException sa) {


            JOptionPane.showMessageDialog(null, "Error de auto cerrable de hibernate  ", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, sa, "Error", JOptionPane.ERROR_MESSAGE);


        }
    }
}


