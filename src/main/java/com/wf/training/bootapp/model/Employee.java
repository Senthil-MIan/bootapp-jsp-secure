package com.wf.training.bootapp.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.wf.training.bootapp.validators.EmployeeCode;



public class Employee {
	
	// @NotNull(message = "Name is mandatory!")
	@NotBlank(message = "Name is mandatory!" )
	private String name;
	
	private String email;
	
	private String contact;
	
	private String country;
	
	private String dob;
	
	// must begin with WF
	@EmployeeCode(prefix = "WF", message = "Invalid employee code! Must begin with 'WF'")
	private String employeeCode;
	
	// @NotBlank(message = "Free Passes are mandatory!") // only for string
	// always use wrapper types
	@NotNull(message = "Free Passes are mandatory!")
	@Min(value = 1, message = "At least 1 free pass is required!")
	private Integer freePasses;
	
	private String[] favoriteLanguages;
	
	
	public String[] getFavoriteLanguages() {
		return favoriteLanguages;
	}



	public void setFavoriteLanguages(String[] favoriteLanguages) {
		this.favoriteLanguages = favoriteLanguages;
	}
	private LinkedHashMap<String, String> countries;
	
	public Employee() {
		// interact with DB and initialize the list
		// dummy values
		this.countries = new LinkedHashMap<String, String>();
		this.countries.put("FR", "France");
		this.countries.put("IN", "India");
		this.countries.put("GR", "Germany");
		this.countries.put("US", "USA");
	}
	
	
	
	
	public String getEmployeeCode() {
		return employeeCode;
	}



	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}



	public Integer getFreePasses() {
		return freePasses;
	}



	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}



	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}





	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		if(this.contact == null)
			this.contact = "222222";
		return contact;
	}
	public void setContact(String contact) {
		if(contact.contentEquals(""))
			this.contact = "333333";
		else
			this.contact = contact;
	}
	
}
