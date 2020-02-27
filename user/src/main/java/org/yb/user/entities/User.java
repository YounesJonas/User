package org.yb.user.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.yb.user.error.Country;



@Document

public class User {

	@Id
	private String id;
	@NotBlank(message = "firstName must be completed !")
	private String firstName;
	@NotBlank(message = "lastName must be completed !")
	private String lastName;
	@NotNull
	@Min(message = "user must be of legal age" , value = 18)
	private int age;
	@NotBlank(message = "user's country must be completed !")
	@Country
	private String country;
	private String mail;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(String id, @NotBlank(message = "firstName must be completed !") String firstName,
			@NotBlank(message = "lastName must be completed !") String lastName,
			@Min(message = "user must be of legal age", value = 18) int age,
			@NotBlank(message = "user's country must be completed !") String country, String mail) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
		this.mail = mail;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", country="
				+ country + ", mail=" + mail + "]";
	}

	

	
	
}
