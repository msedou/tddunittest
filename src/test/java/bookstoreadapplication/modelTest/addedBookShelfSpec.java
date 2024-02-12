package bookstoreadapplication.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bookstoreadapplication.model.Book;
import bookstoreadapplication.model.BookShelf;

public class addedBookShelfSpec {
	
	private BookShelf bookShelf ;
	
	private Book effectiveJava;
	private Book codeComplete;
	private Book mythicalManMonth;
	
	@BeforeEach
	void init() throws Exception{
		bookShelf = new BookShelf();
		effectiveJava =new Book("Effective Java", "Joshua Bloch"
				,LocalDate.of(2008, Month.MAY, 8));
		codeComplete = new Book("Code Complete", "Steve McConnel",
				LocalDate.of(2004, Month.JUNE, 9));
		mythicalManMonth = new Book("The Mythical Man-Month", 
				"Frederick Phillips Brooks", LocalDate.of(1975, Month.JANUARY, 1));
	}

	
	@Test
	void emptyBookshelfWhenNoBookAdded() {
		//ARRANGE
		//ACT
		List<Book> books =bookShelf.books();
		//ASSERT
		assertTrue(books.isEmpty(),()->"Bookshelf should be empty");
		
	}
	
	@Test
	void bookshelfContainsTwoBooksWhenTwoBooksAdded(){
		bookShelf.add(effectiveJava);
		bookShelf.add(codeComplete);
		List<Book> books = bookShelf.books();
		assertEquals(2,books.size(),()->"BookShelf sould have two Books !");
	}
	
	@Test
	void emptyBookShelWhenAddIsCalledWithoutBooks() {
		bookShelf.add();
		List<Book> books = bookShelf.books();
		assertTrue(books.isEmpty(),()->"BookShelf sould have two Books !");
	}
	
	@Test
	void booksReturnedFromBookShelfIsImmutableForClient() {
		bookShelf.add(effectiveJava,codeComplete);
		List<Book> books = bookShelf.books();
		try {
			books.add(mythicalManMonth);
			fail(()->"Should not be able to add book to books");
		}
		catch(Exception e) {
			assertTrue(e instanceof UnsupportedOperationException,()->"Should throw UnsupportedOperationException.");
			
		}
	}
	
	
}
