package model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Departments;
import beans.Employees;
import util.HibernateUtil;

public class EmployeeDao {
	private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public List<Object[]> getEmployeesWithDepartment(String departmentName){
        Query query = EmployeeDao.session.createNativeQuery("select department_id from departments where department_name = ?");
        int i = (Integer) query.setString(1, departmentName).list().get(0);
        System.out.println(i);
        query = EmployeeDao.session.createNativeQuery("select * from employees where department_id= ?");
        query.setInteger(1, i);
        return query.list();
	}
	public List<Object[]> getEmployeesOnSalary(BigDecimal salary){
		Query query = EmployeeDao.session.createNativeQuery("select * from employees where salary > ?");
		query.setBigDecimal(1, salary);
		return query.list();
	}
	public List<Object[]> getEmployeesOnLocationId(int locationId){
		Query query = EmployeeDao.session.createNativeQuery("select employee_id,first_name,last_name,email,phone_number from departments join employees ON employees.department_id = departments.department_id Where location_id = ?");
		query.setInteger(1, locationId);
		return query.list();
	}
}
