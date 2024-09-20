package com.HealthCareDemo.model;

public class Doctor 
{
	    private int did;
	    private String name;
	    private String demail;
	    private long dmob;
	    private String dpass;
	    private String gender;
	    private String dprofess;
		public Doctor() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Doctor(String name, String demail, long dmob, String dpass, String gender, String dprofess) {
			super();
			this.name = name;
			this.demail = demail;
			this.dmob = dmob;
			this.dpass = dpass;
			this.gender = gender;
			this.dprofess = dprofess;
		}

		public Doctor(int did, String name, String demail, long dmob, String dpass, String gender, String dprofess) {
			super();
			this.did = did;
			this.name = name;
			this.demail = demail;
			this.dmob = dmob;
			this.dpass = dpass;
			this.gender = gender;
			this.dprofess = dprofess;
		}
		
		public int getDid() {
			return did;
		}
		public void setDid(int did) {
			this.did = did;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDemail() {
			return demail;
		}
		public void setDemail(String demail) {
			this.demail = demail;
		}
		public long getDmob() {
			return dmob;
		}
		public void setDmob(long dmob) {
			this.dmob = dmob;
		}
		public String getDpass() {
			return dpass;
		}
		public void setDpass(String dpass) {
			this.dpass = dpass;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDprofess() {
			return dprofess;
		}
		public void setDprofess(String dprofess) {
			this.dprofess = dprofess;
		}
	    
	    
	    
}
