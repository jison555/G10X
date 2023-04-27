package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LOCATION", schema = "IMS")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(generator = "GUID")
	//@GenericGenerator(name = "GUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "LOCATION_ID")
	private int locId; 
	@Column(name = "LOC_NAME")
	private String locationName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> prod;
	
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public List<Product> getProd() {
		return prod;
	}
	public void setProd(List<Product> prod) {
		this.prod = prod;
	}
	
	
}
