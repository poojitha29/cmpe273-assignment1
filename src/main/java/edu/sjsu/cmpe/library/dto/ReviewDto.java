/**
 * 
 */
package edu.sjsu.cmpe.library.dto;

import edu.sjsu.cmpe.library.domain.Reviews;

/**
 * @author Poojitha
 *
 */
public class ReviewDto extends LinksDto{
	 public Reviews review;

	    /**
	 * @return the review
	 */
	public Reviews getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(Reviews review) {
		this.review = review;
	}

		/**
	     * @param book
	     */
	    public ReviewDto(Reviews review) {
		super();
		this.review = review;
	    }

		

		
		

}
