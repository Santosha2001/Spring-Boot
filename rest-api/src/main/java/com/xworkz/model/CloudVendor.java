package com.xworkz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CloudVendor {

	@Id
	private String id;
	private String name;
	private String address;
	private String mobile;

	public CloudVendor() {
		// TODO Auto-generated constructor stub
	}

	public CloudVendor(String id, String name, String address, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "CloudAPIService [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
