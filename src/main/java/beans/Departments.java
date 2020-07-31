package beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Departments {
	
	@Id
	@Column(name = "department_id")
	private int departmentId;
	
	@Override
	public String toString() {
		return "Departments [departmentId=" + departmentId + ", depatmentName=" + depatmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + ", employees=" + employees + "]";
	}


	@Column(name = "department_name")
	private String depatmentName;
	
	@Column(name = "manager_id")
	private int managerId;
	
	@Column(name = "location_id")
	private int locationId;
	
	@OneToMany(mappedBy = "department")
	private Set<Employees> employees;
	
	
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepatmentName() {
		return depatmentName;
	}


	public void setDepatmentName(String depatmentName) {
		this.depatmentName = depatmentName;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	
	
	
}
