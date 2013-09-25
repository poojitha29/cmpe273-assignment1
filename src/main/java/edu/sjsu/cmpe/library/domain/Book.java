package edu.sjsu.cmpe.library.domain;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
* @author Poojitha
*
*/

//@JsonInclude(Include.NON_NULL)
public class Book {
    private long isbn;
 //  @NotEmpty(message ="Required field.")
    private String title;
 //  @NotNull(message ="Required field.")
    private String publicationdate;
    private String language;
    private String status = "Available";
    private int numpages;
    List<Author> authors;
    List<Reviews> reviews=new ArrayList<Reviews>();

    // add more fields here

    /**
	 * @return the reviews
	 */
	public List<Reviews> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	/**
     * @return the isbn
     */
    public long getIsbn() {
	return isbn;
    }
    /**
     * @param isbn
     *            the isbn to set
     */
    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }

    /**
	 * @return the publicationdate
	 */
    @JsonProperty("publication-date")
	public String getPublicationdate() {
		return publicationdate;
	}

	/**
	 * @param publicationdate the publicationdate to set
	 */
	
	public void setPublicationdate(String publicationdate) {
		this.publicationdate = publicationdate;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the numpages
	 */
	@JsonProperty("num-pages")
	public int getNumpages() {
		return numpages;
	}

	/**
	 * @param numpages the numpages to set
	 */
	
	public void setNumpages(int numpages) {
		this.numpages = numpages;
	}

	

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

	
}
