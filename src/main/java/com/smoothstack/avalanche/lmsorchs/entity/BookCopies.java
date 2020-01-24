package com.smoothstack.avalanche.lmsorchs.entity;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {

	@EmbeddedId
	private BookCopiesId bookCopiesId;
	
	
	@MapsId("bookId")
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@MapsId("branchId")
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	
	@Column(name = "no_of_copies")
	private Long noOfCopies;

	/*
	 * CONSTRUCTOR
	 */

	public BookCopies() {
		
	}

	public BookCopies(BookCopiesId bookCopiesId, Long noOfCopies) {
		this.bookCopiesId = bookCopiesId;
		this.noOfCopies = noOfCopies;
	}
	/*
	 * GETTERS / SETTERS
	 */
	
	public BookCopiesId getBookCopiesId() {
		return bookCopiesId;
	}

	public void setBookCopiesId(BookCopiesId bookCopiesId) {
		this.bookCopiesId = bookCopiesId;
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
	
	public Long getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Long noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCopies other = (BookCopies) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (noOfCopies == null) {
			if (other.noOfCopies != null)
				return false;
		} else if (!noOfCopies.equals(other.noOfCopies))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((noOfCopies == null) ? 0 : noOfCopies.hashCode());
		return result;
	}
}
