package com.example.user.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class UserAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String discription;
	private String city;
	private String country;
	private int pincode;
	private String state;
	private Set<User> user;
	
	private String createdTime;
	private String createdBy;
	

}
