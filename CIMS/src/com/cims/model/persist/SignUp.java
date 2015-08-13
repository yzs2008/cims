package com.cims.model.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_signUp")
public class SignUp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer signId;
	private Integer userId;
	private String productName;
	private Integer raceId;
	private String productDescription;
	public Integer getSignId() {
		return signId;
	}
	public void setSignId(Integer signId) {
		this.signId = signId;
	}
	public Integer getRegisterId() {
		return userId;
	}
	public void setRegisterId(Integer registerId) {
		this.userId = registerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
