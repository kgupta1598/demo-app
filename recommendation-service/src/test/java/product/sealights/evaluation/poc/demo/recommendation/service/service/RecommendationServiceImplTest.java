package product.sealights.evaluation.poc.demo.recommendation.service.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import product.sealights.evaluation.poc.demo.api.core.recommendation.Recommendation;
import product.sealights.evaluation.poc.demo.recommendation.service.RecommendationServiceImpl;
import product.sealights.evaluation.poc.demo.util.exceptions.InvalidInputException;
import product.sealights.evaluation.poc.demo.util.http.ServiceUtil;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class RecommendationServiceImplTest {

    private RecommendationServiceImpl testObj;

    @Before
    public void setUp() {
        testObj = new RecommendationServiceImpl(new ServiceUtil("100"));
    }

    @Test(expected = InvalidInputException.class)
    public void getRecommendations_throwsInvalidInputException() {
        testObj.getRecommendations(0);
    }

    @Ignore
    @Test
    public void getRecommendations_returnsEmptyList() {
        List<Recommendation> recommendations = testObj.getRecommendations(113);
        assertTrue(recommendations.isEmpty());
    }

    @Test
    public void getRecommendations_returnsReviewsList() {
        List<Recommendation> recommendations = testObj.getRecommendations(1);
        assertTrue(recommendations.size() == 3);
    }
}

