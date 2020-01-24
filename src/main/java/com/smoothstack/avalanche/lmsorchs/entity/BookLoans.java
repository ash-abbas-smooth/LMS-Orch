package com.smoothstack.avalanche.lmsorchs.entity;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {

	@EmbeddedId
	private BookLoansId bookLoansId;
	
	@MapsId("bookId")
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@MapsId("branchId")
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	@MapsId("cardNo")
	@ManyToOne
	@JoinColumn(name = "card_no")
	private Borrower borrower;
	
	@Column(name = "date_out")
	private Date dateOut;
	
	@Column(name = "date_due")
	private Date dateDue;
	
	@Column(name = "date_in")
	private Date dateIn;

	/*
	 * CONSTRUCTOR
	 */

	public BookLoans() {
		
	}

	public BookLoans(BookLoansId bookLoansId, Date dateOut, Date dateDue, Date dateIn) {

		this.bookLoansId = bookLoansId;
		this.dateOut = dateOut;
		this.dateDue = dateDue;
		this.dateIn = dateIn;
	}

	/*
	 * GETTERS/SETTERS
	 */
	public BookLoansId getBookLoansId() {
		return bookLoansId;
	}

	public void setBookLoansId(BookLoansId bookLoansId) {
		this.bookLoansId = bookLoansId;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public Date getDateDue() {
		return dateDue;
	}

	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoans other = (BookLoans) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (dateDue == null) {
			if (other.dateDue != null)
				return false;
		} else if (!dateDue.equals(other.dateDue))
			return false;
		if (dateIn == null) {
			if (other.dateIn != null)
				return false;
		} else if (!dateIn.equals(other.dateIn))
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((dateDue == null) ? 0 : dateDue.hashCode());
		result = prime * result + ((dateIn == null) ? 0 : dateIn.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		return result;
	}
}
