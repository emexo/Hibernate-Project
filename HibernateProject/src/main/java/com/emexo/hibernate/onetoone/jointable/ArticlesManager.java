package com.emexo.hibernate.onetoone.jointable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ArticlesManager {

	public static void main(String[] args) {
		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Category category = new Category();
		category.setName("Hibernate Framework");

		Article articleOne = new Article();
		articleOne.setTitle("One to One Mapping");
		articleOne.setDescription("One-to-One XML Mapping Tutorial");
		articleOne.setKeywords("Hibernate,One-to-One");
		articleOne.setContent("Content of One-to-One ");

		category.setArticle(articleOne);

		Long categoryId = (Long)session.save(category);

		Category category1 = (Category) session.get(Category.class, categoryId);
		System.out.println(category1);

		session.getTransaction().commit();
		session.close();
	}

}