/**
 * 
 */
package edu.sjsu.cmpe.library.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.library.domain.Book;
import edu.sjsu.cmpe.library.domain.Reviews;
import edu.sjsu.cmpe.library.dto.LinkDto;
import edu.sjsu.cmpe.library.dto.LinksDto;
import edu.sjsu.cmpe.library.dto.ReviewDto;
import edu.sjsu.cmpe.library.dto.ReviewsDto;
import edu.sjsu.cmpe.library.repository.BookRepositoryInterface;

//@Path("/v1/books")
@Path("/v1/books/{isbn}/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ReviewResource {
    /** bookRepository instance */
    private final BookRepositoryInterface bookRepository;

    
    public ReviewResource(BookRepositoryInterface bookRepository) {
	this.bookRepository = bookRepository;
    }
  

    @POST
    @Timed(name = "create-review")
    public Response createReview(@PathParam("isbn") LongParam isbn, Reviews request) {
	Book book = bookRepository.getBookByISBN(isbn.get());
	List<Reviews> reviewtemp = book.getReviews();
	reviewtemp.add(request);
	String location = "/books/" + book.getIsbn()+  "/reviews/";
	LinksDto bookResponse = new LinksDto();
	bookResponse.addLink(new LinkDto("view-review", location, "GET"));
	
	// Add other links if needed

	return Response.status(201).entity(bookResponse).build();
    }
    
    
    @GET
    @Path("/{id}/")
    @Timed(name = "view-review")
    public Response getReviewByIsbn(@PathParam("isbn") LongParam isbn,@PathParam("id") int id) {
	Reviews review = bookRepository.getReviewByID(isbn.get(),id);
	Book book = bookRepository.getBookByISBN(isbn.get());
	ReviewDto bookResponse = new ReviewDto(review);
	bookResponse.addLink(new LinkDto("view-book", "/books/" + book.getIsbn() + "/review/" ,
		"GET"));
	
	// add more links

	return Response.status(201).entity(bookResponse).build();
    }
    
    @GET
    @Timed(name = "view-book")
    public Response getReviewByIsbn(@PathParam("isbn") LongParam isbn) {
    	//Author author = bookRepository.getAuthorByIsbn(isbn.get());
    	Book book= bookRepository.getBookByISBN(isbn.get());
    	List<Reviews> review =  book.getReviews();
    	ReviewsDto bookResponse = new ReviewsDto(review);
    	return Response.status(201).entity(bookResponse).build();
    }
    	
    			
     
}
