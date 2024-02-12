package bookstoreadapplication.model;

import java.time.LocalDate;

public class Book implements Comparable<Book>{

	private final String title;
	private final String author;
	private final LocalDate publishedOn;
	public Book(String title, String author, LocalDate publishedOn) {
		super();
		this.title = title;
		this.author = author;
		this.publishedOn = publishedOn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public LocalDate getPublishedOn() {
		return publishedOn;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publishedOn=" + publishedOn + ", getTitle()="
				+ getTitle() + ", getAuthor()=" + getAuthor() + ", getPublishedOn()=" + getPublishedOn()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	@Override
	public int compareTo(Book book) {
		return this.title.compareTo(book.title);
	}
	
	
}
