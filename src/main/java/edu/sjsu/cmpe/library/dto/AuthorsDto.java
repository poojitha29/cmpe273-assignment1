/**
 * 
 */
package edu.sjsu.cmpe.library.dto;

import java.util.List;

import edu.sjsu.cmpe.library.domain.Author;

/**
 * @author Poojitha
 *
 */
public class AuthorsDto extends LinksDto{
	List<Author> author;

    /**
     * @param book
     */
    public AuthorsDto(List<Author> author) {
	super();
	this.author = author;
    }

	/**
	 * @return the author
	 */
	public List<Author> getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(List<Author> author) {
		this.author = author;
	}


}
