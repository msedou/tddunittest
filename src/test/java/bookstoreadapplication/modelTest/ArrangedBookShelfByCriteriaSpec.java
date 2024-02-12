package bookstoreadapplication.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import bookstoreadapplication.model.Book;
import bookstoreadapplication.model.BookShelf;

public class ArrangedBookShelfByCriteriaSpec {
	
	/**
	 * @SECOND FEATURE*
	 * As a user, I should be able to arrange my bookshelf base on certain criteria 
	 * 
	 * **/
	private BookShelf shelf;
	
	
	private Book effectiveJava;
	private Book codeComplete;
	private Book mythicalManMonth;
	
	@BeforeEach
	void init() throws Exception{
		shelf = new BookShelf();
		effectiveJava =new Book("Effective Java", "Joshua Bloch"
				,LocalDate.of(2008, Month.MAY, 8));
		codeComplete = new Book("Code Complete", "Steve McConnel",
				LocalDate.of(2004, Month.JUNE, 9));
		mythicalManMonth = new Book("The Mythical Man-Month", 
				"Frederick Phillips Brooks", LocalDate.of(1975, Month.JANUARY, 1));
	}
	
	@Test void bookShelfArragedByUserProvidedCriteria() {
		shelf.add(effectiveJava, codeComplete, mythicalManMonth);
		List<Book> books = shelf.arrange(Comparator.<Book>naturalOrder().reversed());
		assertEquals(
				Arrays.asList(mythicalManMonth,effectiveJava,codeComplete),
				books,
				()->"Books in a bookShelf are arranged in descending order of book title");
		
	}
	
	@Test
	void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
		shelf.add(effectiveJava, codeComplete, mythicalManMonth);
		shelf.arrange();
		List<Book> books = shelf.books();
		assertEquals(Arrays.asList(effectiveJava, codeComplete, mythicalManMonth),
				books,()->"Books in bookShelf are in insertion Order");
	}
	
	@Test
	void bookshelfArrangedByBookTitle() {
		shelf.add(effectiveJava, codeComplete, mythicalManMonth);
		List<Book> books = shelf.arrange();
		assertEquals(Arrays.asList(codeComplete, effectiveJava, mythicalManMonth),books,
				()->"Books in a bookshelf should be arranged lexicographically by book title");
	}
	
	

}
