package com.HealthCareDemo.model;

public class DocVerify {
	private int did;
	private String dname;
	private String demail;

	public DocVerify() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocVerify(int did, String name, String email) {
		super();
		this.did = did;
		this.dname = name;
		this.demail = email;
	}
	

	public DocVerify(String dname, String demail) {
		super();
		this.dname = dname;
		this.demail = demail;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return dname;
	}

	public void setName(String name) {
		this.dname = name;
	}

	public String getEmail() {
		return demail;
	}

	public void setEmail(String email) {
		this.demail = email;
	}

}
