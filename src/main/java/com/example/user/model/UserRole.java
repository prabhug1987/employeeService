package com.example.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UserRole implements Serializable{

	
	/**
	 * this is generated serial version id
	 */
	private static final long serialVersionUID = 1662799867785003818L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String roleName;
	private String description;

	@Timestamp
	private String createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private String updatedAt;

	@LastModifiedBy
	private String updateBy;

	private Set<User> Users;
}
