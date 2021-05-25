package com.zds.easybuy_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Repository
@Table(name = "easybuy_news")//mybatic通用接口mapper依赖JPA实体类采用JPA
public class News implements Serializable{

	//主键 自动递增
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//ID

	//标题
	@Column(name = "title")
	private String title;//标题

	//内容
	@Column(name = "content")
	private String content;//内容

	//创建时间 格式化
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createTime")
	private Date createTime;//创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
