package product.sealights.evaluation.poc.demo.review.service.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import product.sealights.evaluation.poc.demo.api.core.review.Review;
import product.sealights.evaluation.poc.demo.review.service.ReviewServiceImpl;
import product.sealights.evaluation.poc.demo.util.exceptions.InvalidInputException;
import product.sealights.evaluation.poc.demo.util.http.ServiceUtil;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ReviewServiceImplTest {

    private ReviewServiceImpl testObj;

    @Before
    public void setUp() {
        testObj = new ReviewServiceImpl(new ServiceUtil("100"));
    }

    @Test(expected = InvalidInputException.class)
    public void getReviews_throwsInvalidInputException() {
        testObj.getReviews(0);
    }

    @Ignore
    @Test
    public void getReviews_returnsEmptyList() {
        List<Review> reviews = testObj.getReviews(213);
        assertTrue(reviews.isEmpty());
    }

    @Test
    public void getReviews_returnsReviewsList() {
        List<Review> reviews = testObj.getReviews(1);
        assertTrue(reviews.size() == 3);
    }
}
