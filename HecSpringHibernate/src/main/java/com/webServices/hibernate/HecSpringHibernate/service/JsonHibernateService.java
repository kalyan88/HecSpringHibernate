/**
 * 
 */
package com.webServices.hibernate.HecSpringHibernate.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.webServices.hibernate.HecSpringHibernate.Dao.JsonHibernateDao;
import com.webServices.hibernate.HecSpringHibernate.model.Person;

public class JsonHibernateService {
	
	@Autowired
	private JsonHibernateDao jsonHibernateDao;
	
	private static final Logger logger = Logger.getLogger(JsonHibernateService.class);
	
	public List<Person> getAllPersons() {
		logger.info("JsonHibernateService getPesonData:");
		List<Person> person = jsonHibernateDao.getAllPersons();
		return person;
	}
	
	
	public Person getPersonById(long id) {
		logger.info("JsonHibernateService getPersonById:"+id);
		return jsonHibernateDao.getPersonById(id);
	}
	
	public Person addPerson(Person person){
		logger.info("JsonHibernateService addPerson");
		return jsonHibernateDao.addPerson(person);
	}
	
	public void deletePerson(Person person){
		logger.info("JsonHibernateService deletePerson");
		jsonHibernateDao.deletePerson(person);
	}
}
