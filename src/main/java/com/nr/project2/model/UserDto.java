package com.nr.project2.model;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

		@JsonIgnore
		private int id;

		@JsonIgnore
		private String userNo;

		@JsonProperty("Type")
		private String type;

		@NotEmpty(message = "*Name should not empty!")
		@JsonProperty("Name")
		private String firstName;

		@NotEmpty(message = "*LName should not empty!")
		@JsonProperty("LName")
		private String lastName;
		
		@JsonProperty("Login Id")
		private String loginId;
		
		@JsonProperty("Password")
		private String password;

		public UserDto() {}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserNo() {
			return userNo;
		}

		public void setUserNo(String userNo) {
			this.userNo = userNo;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		
}
