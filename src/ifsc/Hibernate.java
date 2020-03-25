package ifsc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate {

	private SessionFactory sessionFactory;
	private StandardServiceRegistry registry;
	private static Hibernate HIBERNATE;

	private Hibernate() {

	}

	public static Hibernate getInstance() {
		if (HIBERNATE == null) {
			HIBERNATE = new Hibernate();
		}

		return HIBERNATE;
	}

	private SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			try {

				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sessionFactory;
	}

	public Session getSession() {
		return this.getSessionFactory().openSession();
	}

}
