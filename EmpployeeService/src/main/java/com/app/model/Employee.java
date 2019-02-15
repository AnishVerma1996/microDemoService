package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Emp")
@Entity
public class Employee 
{
@Id
private int eid;
@Column(length=15)
private String ename;
@Column(length=50)
private String address;
@Column(length=10)
private int esal;
@Column(length=10)
private int empage;
@Override
public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", address=" + address + ", esal=" + esal + ", empage="
			+ empage + "]";
}
public int getEid() {
	return eid;
}
public void setEid(int eid)
{
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getEsal() {
	return esal;
}
public void setEsal(int esal) {
	this.esal = esal;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getEmpage() {
	return empage;
}
public void setEmpage(int empage) {
	this.empage = empage;
}

}

