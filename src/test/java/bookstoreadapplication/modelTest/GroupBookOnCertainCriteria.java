package bookstoreadapplication.modelTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bookstoreadapplication.model.Book;
import bookstoreadapplication.model.BookShelf;

public class GroupBookOnCertainCriteria {
	
	private BookShelf shelf;
	
	
	private Book effectiveJava;
	private Book codeComplete;
	private Book mythicalManMonth;
	private Book cleanCode;
	
	
	@BeforeEach
	void init() throws Exception{
		shelf = new BookShelf();
		
		
		effectiveJava =new Book("Effective Java", "Joshua Bloch"
				,LocalDate.of(2008, Month.MAY, 8));
		codeComplete = new Book("Code Complete", "Steve McConnel",
				LocalDate.of(2004, Month.JUNE, 9));
		mythicalManMonth = new Book("The Mythical Man-Month", 
				"Frederick Phillips Brooks", LocalDate.of(1975, Month.JANUARY, 1));
		cleanCode = new Book("Clean Code","Robert C. Martin",
				LocalDate.of(2008, Month.APRIL,10));
	}
	
	@Test
	@DisplayName("book inside bookShelf are grouped by publication year ")
	void groupBooksInsideBookShelfByPublicationYear() {
		shelf.add(effectiveJava,codeComplete,mythicalManMonth,cleanCode);
		Map<Year,List<Book>> booksByPublicationYear = shelf.groupByPublicationYear();
		
		
		assertThat(booksByPublicationYear)
		.containsKey(Year.of(2008))
		.containsValue(Arrays.asList(effectiveJava,cleanCode));
		
		assertThat(booksByPublicationYear)
		.containsKey(Year.of(2004))
		.containsValues(Collections.singletonList(codeComplete));
		
		assertThat(booksByPublicationYear)
		.containsKey(Year.of(1975))
		.containsValues(Collections.singletonList(mythicalManMonth));
	}
	
	@Test
	@DisplayName("book inside bookShelf are grouped according to user provided criteria(group by author name)")
	void groupBookByUserProviderCriteria() {
		//ARRANGE
		shelf.add(effectiveJava,codeComplete,mythicalManMonth,cleanCode);
		Map<String, List<Book>> booksByAuthor = shelf.groupBy(Book::getAuthor);
		
		
		assertThat(booksByAuthor)
		.containsKey("Joshua Bloch")
		.containsValues(Collections.singletonList(effectiveJava));
		
	}
	

}
