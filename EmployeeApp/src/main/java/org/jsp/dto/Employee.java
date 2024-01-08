package org.jsp.dto;

public class Employee {
	private int eid;
	private String ename;
	private String email;
	private String epassword;
	private double esalary;
	private long ephone;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public long getEphone() {
		return ephone;
	}
	public void setEphone(long ephone) {
		this.ephone = ephone;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", epassword=" + epassword
				+ ", esalary=" + esalary + ", ephone=" + ephone + "]";
	}
	
}
