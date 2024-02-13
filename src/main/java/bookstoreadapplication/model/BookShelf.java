package bookstoreadapplication.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookShelf {
	
	private final List<Book> books = new ArrayList<>();

//	public List<String> books() {
//		return Collections.emptyList();
//	}
	
	public List<Book> books() {
		return Collections.unmodifiableList(books) ;
	}

	public void add(Book ...bookName) {
		Arrays.stream(bookName).forEach(book -> books.add(book));
	}

	public List<Book> arrange() {
		//books.sort(Comparator.naturalOrder());
		return books.stream().sorted().collect(Collectors.toList());
	}

	public List<Book> arrange(Comparator<Book> criteria) {
		return books.stream().sorted(criteria).collect(Collectors.toList());
	}

	public Map<Year, List<Book>> groupByPublicationYear() {
		
		return groupBy(book -> Year.of(book.getPublishedOn().getYear()));
		/**return books
				.stream()
				.collect(Collectors.groupingBy(book -> Year.of(book.getPublishedOn().getYear())));**/
	}

	public <K> Map<K,List<Book>> groupBy(Function<Book,K> fx) {
		return books
				.stream()
				.collect(Collectors.groupingBy(fx));
	}

}
