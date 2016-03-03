package com.endlesswl.knowledge.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "user_info")
public class UserInfo extends IdEntity {

	private String email;
	private Integer city;
	private String address;
	private String realName;
	private String mobile;
	private Integer genter;
	private String qq;
	private String avatar;
	private String regip;
	private String nickName;

	public UserInfo() {

	}

	public UserInfo(Long id) {

		this.id = id;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public Integer getCity() {

		return city;
	}

	public void setCity(Integer city) {

		this.city = city;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getRealName() {

		return realName;
	}

	public void setRealName(String realName) {

		this.realName = realName;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public Integer getGenter() {

		return genter;
	}

	public void setGenter(Integer genter) {

		this.genter = genter;
	}

	public String getQq() {

		return qq;
	}

	public void setQq(String qq) {

		this.qq = qq;
	}

	public String getAvatar() {

		return avatar;
	}

	public void setAvatar(String avatar) {

		this.avatar = avatar;
	}

	public String getRegip() {

		return regip;
	}

	public void setRegip(String regip) {

		this.regip = regip;
	}

	public String getNickName() {

		return nickName;
	}

	public void setNickName(String nickName) {

		this.nickName = nickName;
	}

}
