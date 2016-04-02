package com.webServices.hibernate.HecSpringHibernate.Dao;

import java.util.List;

import com.webServices.hibernate.HecSpringHibernate.model.Person;

public interface JsonHibernateDao {
	
	public List<Person> getAllPersons();
	
	public Person getPersonById(long id) ;
	
	public Person addPerson(Person person);
	
	public void deletePerson(Person person);

}
