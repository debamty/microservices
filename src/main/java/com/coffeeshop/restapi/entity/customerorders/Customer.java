package com.coffeeshop.restapi.entity.customerorders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aindex")
	private Long id;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="customer_phone")
	private String customerPhone;
	@Column(name="customer_email")
	private String customerEmail;
	@Column(name="creation_date")
	private Date createdDate = new Date();
	@Column(name="lastupdated_date")
	private Date updatedDate =new Date();
	@Column(name="isActive")
	private boolean isCustomerStillRetained;
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY )
	@JoinColumn(name="customer_id")
	private List<Order> orderList =new ArrayList<>() ;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public boolean isCustomerStillRetained() {
		return isCustomerStillRetained;
	}
	public void setCustomerStillRetained(boolean isCustomerStillRetained) {
		this.isCustomerStillRetained = isCustomerStillRetained;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


}
