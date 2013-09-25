/**
 * 
 */
package edu.sjsu.cmpe.library.dto;

import java.util.List;

import edu.sjsu.cmpe.library.domain.Reviews;

/**
 * @author Poojitha
 *
 */
public class ReviewsDto extends LinksDto{
	List<Reviews> review;

    /**
     * @param book
     */
    public ReviewsDto(List<Reviews> review) {
	super();
	this.review = review;
    }

	/**
	 * @return the review
	 */
	public List<Reviews> getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(List<Reviews> review) {
		this.review = review;
	}
	
}
