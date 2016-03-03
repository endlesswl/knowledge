/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.endlesswl.knowledge.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.springside.modules.utils.Collections3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

@Entity
@Table(name = "u_user")
public class User extends IdEntity {

	private String loginName;
	private String name;
	private String plainPassword;
	private String password;
	private String salt;
	private Date registerDate;

	private List<Role> roleList = Lists.newArrayList(); // 有序的关联对象集合

	public User() {

	}

	public User(Long id) {

		this.id = id;
	}

	@NotBlank
	public String getLoginName() {

		return loginName;
	}

	public void setLoginName(String loginName) {

		this.loginName = loginName;
	}

	@NotBlank
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	// 不持久化到数据库，也不显示在Restful接口的属性.
	@Transient
	@JsonIgnore
	public String getPlainPassword() {

		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {

		this.plainPassword = plainPassword;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getSalt() {

		return salt;
	}

	public void setSalt(String salt) {

		this.salt = salt;
	}

	// 多对多定义
	@ManyToMany
	@JoinTable(name = "s_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序
	@OrderBy("id ASC")
	// 缓存策略
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Role> getRoleList() {

		return roleList;
	}

	public void setRoleList(List<Role> roleList) {

		this.roleList = roleList;
	}

	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getRegisterDate() {

		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {

		this.registerDate = registerDate;
	}

	@Transient
	@JsonIgnore
	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ", ");
	}
	
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this);
	}
}