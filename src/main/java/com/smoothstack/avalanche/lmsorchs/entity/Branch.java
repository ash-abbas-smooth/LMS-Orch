/**
 * 
 */
package com.smoothstack.avalanche.lmsorchs.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ashian
 *
 */
@Entity
@Table(name = "tbl_library_branch")
public class Branch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	
	@Column(name = "branchName")
	private String branchName;
	
	@Column(name = "branchAddress")
	private String address;
	
	@OneToMany(mappedBy ="id.branch", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookLoans> bookLoans;
	
	@OneToMany(mappedBy = "id.branch", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookCopies> bookCopies;
	/*
	 * Getters / Setters
	 */
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

//	public List<BookLoans> getBookLoans() {
//		return bookLoans;
//	}
//	public void setBookLoans(List<BookLoans> bookLoans) {
//		this.bookLoans = bookLoans;
//	}
	/*
	 * EQUALS / HASHCODE
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchId, branchName, address);
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null ||getClass() != o.getClass())
			return false;
		Branch other = (Branch) o;
		return Objects.equals(getBranchName(), other.getBranchName()) && Objects.equals(getAddress(), other.getAddress());
	}
	
	
}
