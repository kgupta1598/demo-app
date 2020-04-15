package product.sealights.evaluation.poc.demo.productcomposite.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import product.sealights.evaluation.poc.demo.api.composite.product.ProductAggregate;
import product.sealights.evaluation.poc.demo.api.core.product.Product;
import product.sealights.evaluation.poc.demo.api.core.recommendation.Recommendation;
import product.sealights.evaluation.poc.demo.api.core.review.Review;
import product.sealights.evaluation.poc.demo.util.exceptions.NotFoundException;
import product.sealights.evaluation.poc.demo.util.http.ServiceUtil;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ProductCompositeServiceImplTest {

    @InjectMocks
    private ProductCompositeServiceImpl testObj;

    @Mock
    private ServiceUtil serviceUtil;

    @Mock
    private ProductCompositeIntegration productCompositeIntegration;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NotFoundException.class)
    public void getProduct_throwsNotFoundException() {
        when(productCompositeIntegration.getProduct(Mockito.anyInt())).thenReturn(null);
        testObj.getProduct(0);
    }

    @Test
    public void getProduct_returnExpectedProductAggregate() {
        PodamFactory pojoFactory = new PodamFactoryImpl();
        Product product = pojoFactory.manufacturePojo(Product.class);
        List<Review> reviews = pojoFactory.manufacturePojo(List.class, Review.class);
        List<Recommendation> recommendations = pojoFactory.manufacturePojo(List.class, Recommendation.class);
        final int productId = 1;

        when(productCompositeIntegration.getProduct(Mockito.anyInt())).thenReturn(product);
        when(productCompositeIntegration.getReviews(Mockito.anyInt())).thenReturn(reviews);
        when(productCompositeIntegration.getRecommendations(Mockito.anyInt())).thenReturn(recommendations);

        ProductAggregate productAggregate = testObj.getProduct(productId);

        assertTrue(productAggregate.getProductId() == product.getProductId());
        assertTrue(productAggregate.getRecommendations().size() == recommendations.size());
        assertTrue(productAggregate.getReviews().size() == reviews.size());
    }

}
