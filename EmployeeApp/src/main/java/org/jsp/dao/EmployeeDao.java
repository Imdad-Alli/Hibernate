package org.jsp.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.dto.Employee;

public class EmployeeDao {
	static Session session = new Configuration().configure().buildSessionFactory().openSession();
	static Transaction transaction = session.beginTransaction();

	public static void saveOrUpdateEmp(Employee emp) {
		session.saveOrUpdate(emp);
		transaction.commit();
	}

	public static Employee verifyEmpByEmailPassword(String email, String password) {
		String hql = "select e from Employee e where e.email=?1 and e.epassword=?2";
		Query<Employee> query = session.createQuery(hql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			Employee emp = query.getSingleResult();
			return emp;
		}
		catch(NoResultException e) {
			return null;
		}
		
	}

	public static Employee verifyEmpByPhoneAndPassword(Long phone, String password) {
		String hql = "select e from Employee e where e.ephone = ?1 and e.epassword = ?2";
		Query<Employee> query = session.createQuery(hql);
		query.setParameter(1, phone);
		query.setParameter(2, password);
		
		try {
			Employee singleResult = query.getSingleResult();
			return singleResult;
		} catch(NoResultException e) {
			return null;
		}
		
	}
	public static void deleteEmp(int id) {
		Employee employee = session.get(Employee.class, id);
		
		if(employee!=null) {
			session.delete(employee);
			transaction.commit();
			System.out.println("Empoyee Deleted");
		} else {
			System.out.println("Entered id is not present in table");
		}
	}

	public static void fetchAllEmp() {
		String hql = "from Employee";
		Query<Employee> query = session.createQuery(hql);
		List<Employee> employees = query.getResultList();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

	public static Employee fetchEmp(int id) {
		return session.get(Employee.class, id);
	}

}
