package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import edu.sjsu.cmpe.library.domain.Author;
import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.Reviews;

public class BookRepository implements BookRepositoryInterface {

	
	/** In-memory map to store books. (Key, Value) -> (ISBN, Book) */
private final ConcurrentHashMap<Long, Book> bookInMemoryMap;


	/** Never access this key directly; instead use generateISBNKey() */
private long isbnKey;

private int authorID;
private int reviewID;


public BookRepository(ConcurrentHashMap<Long, Book> bookMap){
	checkNotNull(bookMap, "bookMap must not be null for BookRepository");
	bookInMemoryMap = bookMap;
	isbnKey = 0;

}


/**
* This should be called if and only if you are adding new books to the
* repository.
*
* @return a new incremental ISBN number
*/
private final Long generateISBNKey() {
// increment existing isbnKey and return the new value
return Long.valueOf(++isbnKey);
}

private final int generateAuthorID() {
// increment AuthorID and return the new value
return ++authorID;
}

    private final int generateReviewID() {
    	// increment existing isbnKey and return the new value
    	return ++reviewID;
        }
/**
* This will auto-generate unique ISBN for new books.
*/
@Override
public Book saveBook(Book newBook) {
checkNotNull(newBook, "newBook instance must not be null");

List<Author> author = newBook.getAuthors();
Long isbn = generateISBNKey();
newBook.setIsbn(isbn);

for(int i=0; i<author.size();i++){
Author authortemp =author.get(i);
authortemp.setId(generateAuthorID());
}

// Finally, save the new book into the map
bookInMemoryMap.putIfAbsent(isbn, newBook);

return newBook;
}

public Book createReview(Book newBook) {
	List<Reviews> review = newBook.getReviews();
	Long isbn= newBook.getIsbn();
	// TODO: create and associate other fields such as author
	for(int i=0; i<review.size();i++){
	Reviews reviewtemp =review.get(i);
	reviewtemp.setId(generateReviewID());
	}
	
	// Finally, save the new book into the map
	bookInMemoryMap.putIfAbsent(isbn, newBook);

	return newBook;
//Reviews reviewtemp = new Reviews();
//return reviewtemp;
}

/**
* @see edu.sjsu.cmpe.library.repository.BookRepositoryInterface#getBookByISBN(java.lang.Long)
*/
@Override
public Book getBookByISBN(Long isbn) {
checkArgument(isbn > 0,
"ISBN was %s but expected greater than zero value", isbn);
return bookInMemoryMap.get(isbn);
}


public Reviews getReviewByID(Long isbn,int id){
	Book book= bookInMemoryMap.get(isbn);
	
	List<Reviews> review =book.getReviews();
	for(int i=0; i<review.size();i++){
		if(review.get(i).getId()==id){
	return review.get(i);
	}
	}
	return null;
}



public boolean getAuthorByIsbn(Long isbn){
	if(bookInMemoryMap.containsKey(isbn)){
		bookInMemoryMap.get(isbn);
		return true;
	}
	else
	return false;
}

public boolean getReviewsByIsbn(Long isbn){
	if(bookInMemoryMap.containsKey(isbn)){
		bookInMemoryMap.get(isbn);
		return true;
	}
	else
	return false;
}

public Author getAuthorByID(Long isbn, int id){
Book book= bookInMemoryMap.get(isbn);
	
	List<Author> author =book.getAuthors();
	for(int i=0; i<author.size();i++){
		if(author.get(i).getId()==id){
	return author.get(i);
	}
	}
	return null;
	
}

public boolean deleteBookByISBN(Long isbn) {
if(bookInMemoryMap.containsKey(isbn)){
bookInMemoryMap.remove(isbn);
return true;
}
else
return false;
}

public boolean updateBookByISBN(Long isbn, String status){

if(bookInMemoryMap.containsKey(isbn)){
Book uBook = bookInMemoryMap.get(isbn);
uBook.setStatus(status);
return true;}
else
return false;
}




}


