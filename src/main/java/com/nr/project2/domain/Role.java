package com.nr.project2.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role")
	private String role;

	@Column(name = "description")
	private String description;

	@Column(name = "version")
	private int version;

	@Column(name = "isdeleted")
	private boolean isdeleted;
	
	   @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "role_access", joinColumns = @JoinColumn(name = "role"), inverseJoinColumns = @JoinColumn(name = "access"))
	private Set<Access> accesses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set<Access> getAccesses() {
		return accesses;
	}

	public void setAccesses(Set<Access> accesses) {
		this.accesses = accesses;
	}

}
