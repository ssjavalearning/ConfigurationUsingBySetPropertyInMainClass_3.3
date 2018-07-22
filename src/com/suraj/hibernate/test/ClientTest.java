package com.suraj.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suraj.hibernate.model.Employee;

public class ClientTest {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_db");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		
		configuration.addResource("employee.hbm.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		//Employee employee = (Employee) session.get(Employee.class, 1001);
		
		Employee employee = (Employee) session.load(Employee.class, 1001);
		System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName()+"\t"+employee.getSalary());
		
		session.close();
		factory.close();
	}

}
