package com.parabul.adviser.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "car_infos")
@NamedQuery(name = "CarInfo.findAll", query = "SELECT c FROM CarInfo c")
public class CarInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String condition;

	private Integer manufactureyear;

	private Integer mileage;

	private Integer price;

	private String title;

	private String transmissiontype;

	public CarInfo() {
		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getManufactureyear() {
		return this.manufactureyear;
	}

	public void setManufactureyear(Integer manufactureyear) {
		this.manufactureyear = manufactureyear;
	}

	public Integer getMileage() {
		return this.mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTransmissiontype() {
		return this.transmissiontype;
	}

	public void setTransmissiontype(String transmissiontype) {
		this.transmissiontype = transmissiontype;
	}

}