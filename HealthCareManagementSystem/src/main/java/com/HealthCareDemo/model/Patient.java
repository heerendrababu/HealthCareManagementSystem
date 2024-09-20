package com.HealthCareDemo.model;

public class Patient 
{
  private int pid;
  private String pname;
  private int age;
  private String bloodGroup;
  private String email;
  private long mobno;
  private String password;
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
public Patient(int pid, String pname, int age, String bloodGroup, String email, long mobno, String password) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.age = age;
	this.bloodGroup = bloodGroup;
	this.email = email;
	this.mobno = mobno;
	this.password = password;
}
public Patient(String pname, int age, String bloodGroup, String email, long mobno, String password) {
	super();
	this.pname = pname;
	this.age = age;
	this.bloodGroup = bloodGroup;
	this.email = email;
	this.mobno = mobno;
	this.password = password;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobno() {
	return mobno;
}
public void setMobno(long mobno) {
	this.mobno = mobno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
}
