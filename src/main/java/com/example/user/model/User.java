package com.example.user.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int age;
	private String email;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false, updatable = false)
	@CreatedBy
	private String createdBy;
	private Date dateOfBirth;
	private String description;
	private String firstName;
	private String lastName;

	private String password;
	private String passwordConfirm;

	@LastModifiedBy
	private Date updateAt;

	@LastModifiedDate
	private String updateBy;

	private String userName;

	private Set<UserRole> roles;
}
