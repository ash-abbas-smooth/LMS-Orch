package com.smoothstack.avalanche.lmssecure.entity;


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
	/*
	 * EQUALS/HASHCODE
	 */
	@Override
	public boolean equals(Object o)
	{
		if( this == o) return true;
		if( o == null || getClass() != o.getClass())
			return false;
		BookCopies other = (BookCopies) o;
		return Objects.equals(getBookCopiesId(), other.getBookCopiesId())
				&& Objects.equals(getNoOfCopies(), other.getNoOfCopies());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(bookCopiesId,noOfCopies);
	}
}
