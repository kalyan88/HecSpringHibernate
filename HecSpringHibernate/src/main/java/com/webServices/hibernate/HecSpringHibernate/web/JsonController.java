/**
 * 
 */
package com.webServices.hibernate.HecSpringHibernate.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webServices.hibernate.HecSpringHibernate.model.Person;
import com.webServices.hibernate.HecSpringHibernate.service.JsonHibernateService;

/**
 * @author kalyangurugubelli
 *
 */

@Controller
public class JsonController {

	@Autowired
	private JsonHibernateService jsonHibernateService;
	
	private static final Logger logger = Logger.getLogger(JsonController.class);
		
	
	
	/**Will get the list of all persons from the person table*/
	@RequestMapping(value="/getPersons", method = RequestMethod.GET)
	public @ResponseBody List<Person> getAllPersons()
	{
		logger.info("JsonController getAllPersons");
		List<Person> person = jsonHibernateService.getAllPersons();
		return person;
	}
	
	/**Will get person data from the person table by id*/
	@RequestMapping(value="/getPersonById/{id}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Person getPersonsById(@PathVariable long id)
	{
		logger.info("JsonController getPersonsById");
		return jsonHibernateService.getPersonById(id);
	}
	
	
	/**this method works both as POST AND PUT, if the person is new it add's new row to the table and if its existing row it updates row in Person table*/
	@RequestMapping(value="/addPerson", method = RequestMethod.POST)
	public @ResponseBody Person addPerson(@RequestBody Person person)
	{
		logger.info("JsonController addPerson");
		return jsonHibernateService.addPerson(person);
	}
	
	/**This method will delete the person from the list and will get the remaining persons from the list*/
	@RequestMapping(value="/deletePerson", method = RequestMethod.DELETE)
	public @ResponseBody List<Person> deletePerson(@RequestBody Person person)
	{
		logger.info("JsonController deletePerson");
		jsonHibernateService.deletePerson(person);
		/**Returns remaining persons in the list*/
		return jsonHibernateService.getAllPersons();
	}
}
