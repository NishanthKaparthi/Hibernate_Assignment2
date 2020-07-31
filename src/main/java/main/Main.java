package main;

import model.EmployeeDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import beans.Employees;

public class Main {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		//get employees using department name
		List<Object[]> empList = dao.getEmployeesWithDepartment("Administration");
		int i = 0;
		for(Object[] e: empList) {
			Employees emp = new Employees();
			emp.setEmployeeId((int)Integer.parseInt(e[0].toString()));
			emp.setFirstName(e[1].toString());
			emp.setLastName(e[2].toString());
			emp.setEmail(e[3].toString());
			emp.setPhoneNumber(e[4].toString());
			emp.setHireDate((java.util.Date)e[5]);
			emp.setJobId(e[6].toString());
			System.out.println(emp.toString());
		}
		
		//get employees using salary condition
		List<Object[]> empListOnSalary = dao.getEmployeesOnSalary(new BigDecimal(6500));
		for(Object[] e: empListOnSalary) {
			Employees emp = new Employees();
			emp.setEmployeeId((int)Integer.parseInt(e[0].toString()));
			emp.setFirstName(e[1].toString());
			emp.setLastName(e[2].toString());
			emp.setEmail(e[3].toString());
			emp.setPhoneNumber(e[4].toString());
			emp.setHireDate((java.util.Date)e[5]);
			emp.setJobId(e[6].toString());
			System.out.println(emp.toString());
		}
			//get employees using location id
		List<Object[]> empListOnLocationId = dao.getEmployeesOnLocationId(2400);
		for(Object[] e: empListOnLocationId) {
			Employees emp = new Employees();
			emp.setEmployeeId((int)Integer.parseInt(e[0].toString()));
			emp.setFirstName(e.toString());
			emp.setLastName(e[2].toString());
			emp.setEmail(e[3].toString());
			emp.setPhoneNumber(e[4].toString());
//			emp.setHireDate((java.util.Date)e[5]);
//			emp.setJobId(e[6].toString());
			System.out.println("Employees [employeeId=" + emp.getEmployeeId() + ", firstName=" + emp.getFirstName() + ", lastName=" + emp.getLastName()+ ", email=" + emp.getEmail() + ", phoneNumber=" + emp.getPhoneNumber()+"]");
		}
	}

}
