package com.smoothstack.avalanche.lmsorchs.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_borrower")
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "borrower",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<BookLoans> loans;
	/*
	 * CONSTRUCTORS
	 */
	public Borrower() {}
	public Borrower(Long id, String name, String address, String phone) {
		this.cardNo = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	/*
	 * GETTERS/SETTERS
	 */
	public Long getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(Long id) {
		this.cardNo = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Borrower other = (Borrower) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (loans == null) {
			if (other.loans != null)
				return false;
		} else if (!loans.equals(other.loans))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((loans == null) ? 0 : loans.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
}
