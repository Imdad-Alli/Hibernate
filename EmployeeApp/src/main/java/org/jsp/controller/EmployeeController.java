package org.jsp.controller;

import java.util.Scanner;

import org.jsp.dao.EmployeeDao;
import org.jsp.dto.Employee;

public class EmployeeController {
	static  Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("1. save");
		System.out.println("2. fetch By id");
		System.out.println("3. update");
		System.out.println("4. verify (Email and Password)");
		System.out.println("5. verify (Phone and Password)");
		System.out.println("6. delete");
		System.out.println("7. fetchAll");

		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			save();
			break;
		case 2:
			fetch();
			break;
		case 3:
			update();
			break;
		case 4:
			verifyByEmailAndPassword();
			break;
		case 5:
			verifyByPhoneAndPassword();
			break;
		case 6:
			delete();
			break;
		case 7:
			fetchAll();
			break;
		}
	}

	private static void fetch() {
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		Employee emp = EmployeeDao.fetchEmp(id);
		if(emp==null) {
			System.out.println("Employee not found");
		}else {
			System.out.println(emp);
		}
	}

	private static void fetchAll() {
		EmployeeDao.fetchAllEmp();
	}

	private static void delete() {
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		
		EmployeeDao.deleteEmp(id);
	}

	private static void verifyByPhoneAndPassword() {
		System.out.println("Enter Phone and password: ");
		long phone = sc.nextLong();
		String password = sc.next();
		
		if(EmployeeDao.verifyEmpByPhoneAndPassword(phone, password)!=null) {
			System.out.println("Verified successfully");
		}else {
			System.out.println("Entered Phone and Password are mismatched");
		}
	}

	private static void verifyByEmailAndPassword() {
		System.out.println("Enter Email and Password: ");
		String email = sc.next();
		String password = sc.next();
		
		if(EmployeeDao.verifyEmpByEmailPassword(email, password)!=null) {
			System.out.println("Veryfied Successfully");
		}else {
			System.out.println("Entered Email and Password are mismatched");
		
		}
	}

	private static void update() {
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		
//		Session session = new Configuration().configure().buildSessionFactory().openSession();
//		Employee emp = session.get(Employee.class, id);
		
		Employee emp = EmployeeDao.fetchEmp(id);
		if(emp==null) {
			save();			
		} else {
			System.out.println("Enter name, email, password, salary, phone: ");
			emp.setEname(sc.next());
			emp.setEmail(sc.next());
			emp.setEpassword(sc.next());		
			emp.setEsalary(sc.nextDouble());
			emp.setEphone(sc.nextLong());
			EmployeeDao.saveOrUpdateEmp(emp);
			System.out.println("Employee updated");
		}
			
	}

	public static void save() {
		System.out.println("Enter name, email, password, salary, phone: ");
		
		Employee emp =new Employee();
		emp.setEname(sc.next());
		emp.setEmail(sc.next());
		emp.setEpassword(sc.next());
		emp.setEsalary(sc.nextDouble());
		emp.setEphone(sc.nextLong());
		
		EmployeeDao.saveOrUpdateEmp(emp);
		System.out.println("Employee saved");
	}

}
