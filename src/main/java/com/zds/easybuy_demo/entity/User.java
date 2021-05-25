package com.zds.easybuy_demo.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Table(name = "easybuy_user")
public class User implements Serializable{
	//主键
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//登录名
	@Column(name = "loginName")
	private String loginName;//登录名称

	//用户名
	@Column(name = "userName")
	private String userName;//用户名

	//密码
	@Column(name = "password")
	private String password;//密码

	//性别(1:男 0：女)
	@Column(name = "sex")
	private Integer sex;//性别

	//身份证号
	@Column(name = "identityCode")
	private String identityCode;

	//邮箱
	@Column(name = "email")
	private String email;//电子邮箱

	//手机
	@Column(name = "mobile")
	private String mobile;//电话

	//类型（1：后台 0:前台）
	@Column(name = "type")
	private Integer type;//用户类别

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", loginName='" + loginName + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", sex=" + sex +
				", identityCode='" + identityCode + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", type=" + type +
				'}';
	}
}
