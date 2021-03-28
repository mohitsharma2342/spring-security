package com.spring.security.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@Column(name = "email")
	private String email;
	
	private Boolean isActive;	
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_by")
	private Date createdBy;
	
	@Column(name = "updated_by")
	private Date updatedBy;	
	
	@Column(name = "created_date")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "updated_date")
	@LastModifiedDate
    private Date updatedDate;
	
	@OneToOne(targetEntity=UserRole.class,cascade=CascadeType.MERGE)
	@JoinColumn(name="role_id",referencedColumnName="id")
	private UserRole userRoles;;


	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
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

	public UserRole getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRole userRoles) {
		this.userRoles = userRoles;
	}	
	
	

}