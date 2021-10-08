package com.example.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javassist.SerialVersionUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class User implements Serializable{
	private static final long SerialVersionUID = 1L;
	
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
	private char enabled;
	private String firstName;
	private String lastName;

	private String password;
	private String passwordConfirm;

	@LastModifiedBy
	private Date updateAt;

	@LastModifiedDate
	private String updateBy;

	@NotBlank
	@NotEmpty(message = "Please enter the user name")
	@Size(min=3, max =  20 , message="Please enter the value between 2 and 20")
	private String userName;

	@OneToMany
	private Set<UserRole> userRoles;
	
	@OneToMany
	private Set<UserAddress> userAddresses;
}
