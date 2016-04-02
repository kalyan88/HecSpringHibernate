package com.webServices.hibernate.HecSpringHibernate.Dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.webServices.hibernate.HecSpringHibernate.model.Person;

public class JsonHibernateDaoImpl implements JsonHibernateDao{
	
	private static final Logger logger = Logger.getLogger(JsonHibernateDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Person> getAllPersons() {
		logger.info("JsonHibernateDaoImpl getAllPersons");
		List<Person> persons = sessionFactory.getCurrentSession().
				createQuery("FROM Person").list();
		return persons;
	}
	
	public Person getPersonById(long id) {
			logger.info("JsonHibernateDaoImpl getPersonById");
			String sql = "FROM Person where id = :id";
			Query query=sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("id", id);
			
			List<Person> persons = query.list();
			Person person = persons.get(0);	
			return person;
	}
	
	
	public Person addPerson(Person person){
		logger.info("JsonHibernateDaoImpl addPerson");
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(person);
		session.beginTransaction().commit();
		session.close();
		return person;
		
	}
	
	public void deletePerson(Person person){
		logger.info("JsonHibernateDaoImpl deletePerson");
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		session.delete(person);
		session.beginTransaction().commit();
		session.close();
	}

}
