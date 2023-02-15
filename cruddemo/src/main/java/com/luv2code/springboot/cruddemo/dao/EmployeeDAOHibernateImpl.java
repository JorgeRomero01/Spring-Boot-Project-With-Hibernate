package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	//contructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public EmployeeDAOHibernateImpl() {
		
	}

	@Override
	public List<Employee> findAll() {
		
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		//get results
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void delete(int theId) {
		
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id = employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	

}
