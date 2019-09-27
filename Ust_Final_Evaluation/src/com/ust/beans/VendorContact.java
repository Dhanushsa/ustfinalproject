package com.ust.beans;

public class VendorContact{
	private long v_Id;
	private String v_Name;
	private String v_Addr;
	private String v_Loc;
	private String v_Serv;
	private int pincode;
	private String isActive;
	
	private long c_Id;
	private String c_Name;
	private String department;
	private String email;
	private String phone;
	
	//setters and getters
	
	public long getV_Id() {
		return v_Id;
	}
	public void setV_Id(long v_Id) {
		this.v_Id = v_Id;
	}
	public String getV_Name() {
		return v_Name;
	}
	public void setV_Name(String v_Name) {
		this.v_Name = v_Name;
	}
	public String getV_Addr() {
		return v_Addr;
	}
	public void setV_Addr(String v_Addr) {
		this.v_Addr = v_Addr;
	}
	public String getV_Loc() {
		return v_Loc;
	}
	public void setV_Loc(String v_Loc) {
		this.v_Loc = v_Loc;
	}
	public String getV_Serv() {
		return v_Serv;
	}
	public void setV_Serv(String v_Serv) {
		this.v_Serv = v_Serv;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public long getC_Id() {
		return c_Id;
	}
	public void setC_Id(long c_Id) {
		this.c_Id = c_Id;
	}
	public String getC_Name() {
		return c_Name;
	}
	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//no parameter constructor
	
	public VendorContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//all parameter constructor
	
	public VendorContact(long v_Id, String v_Name, String v_Addr, String v_Loc,
			String v_Serv, int pincode, String isActive, long c_Id,
			String c_Name, String department, String email, String phone) {
		super();
		this.v_Id = v_Id;
		this.v_Name = v_Name;
		this.v_Addr = v_Addr;
		this.v_Loc = v_Loc;
		this.v_Serv = v_Serv;
		this.pincode = pincode;
		this.isActive = isActive;
		this.c_Id = c_Id;
		this.c_Name = c_Name;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "VendorContact [v_Id=" + v_Id + ", v_Name=" + v_Name
				+ ", v_Addr=" + v_Addr + ", v_Loc=" + v_Loc + ", v_Serv="
				+ v_Serv + ", pincode=" + pincode + ", isActive=" + isActive
				+ ", c_Id=" + c_Id + ", c_Name=" + c_Name + ", department="
				+ department + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

	
	
	

}
