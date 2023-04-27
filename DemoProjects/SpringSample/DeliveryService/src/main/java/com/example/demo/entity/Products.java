package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue
	@Column(name = "SL.NO")
	private int SlNo;
	@Column(name = "PRODUCT_ID")
	private int prodId;
	@Column(name = "PROD_NAME")
	private String name;
	@Column(name = "PRICE_PER_UNIT")
	private double price;
	@Column(name = "DISCRIPTION")
	private String discription;
	@Column(name = "QUANTITY")
	private int stockLevel;
	@Column(name = "MANUFACTURE_DATE")
	private Date manDate;
	@Column(name = "EXPIRE_DATE")
	private Date expDate;
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getSlNo() {
		return SlNo;
	}
	public void setSlNo(int slNo) {
		SlNo = slNo;
	}
	public int getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	public Date getManDate() {
		return manDate;
	}
	public void setManDate(Date manDate) {
		this.manDate = manDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	

}
