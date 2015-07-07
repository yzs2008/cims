package com.cims.model.persist;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cims_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private Date registerTime;
	private String gender;
	private String realName;
	private String phone;
	private String avatar;
	private Integer targetMatch;
	private String descrition;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public String getGender() {
		return gender;
	}
	public String getRealName() {
		return realName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAvatar() {
		return avatar;
	}
	public Integer getTargetMatch() {
		return targetMatch;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setTargetMatch(Integer targetMatch) {
		this.targetMatch = targetMatch;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
}
