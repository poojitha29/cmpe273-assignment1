/**
 * 
 */
package edu.sjsu.cmpe.library.dto;
import edu.sjsu.cmpe.library.domain.Author;

/**
 * @author Poojitha
 *
 */

	public class AuthorDto extends LinksDto {
	    public Author author;

	    /**
	     * @param book
	     */
	    public AuthorDto(Author author) {
		super();
		this.author = author;
	    }

		/**
		 * @return the author
		 */
		public Author getAuthor() {
			return author;
		}

		/**
		 * @param author the author to set
		 */
		public void setAuthor(Author author) {
			this.author = author;
		}

		
}
