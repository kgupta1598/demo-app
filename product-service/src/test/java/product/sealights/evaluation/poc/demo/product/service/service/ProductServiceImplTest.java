package product.sealights.evaluation.poc.demo.product.service.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import product.sealights.evaluation.poc.demo.api.core.product.Product;
import product.sealights.evaluation.poc.demo.api.core.review.Review;
import product.sealights.evaluation.poc.demo.product.service.ProductServiceImpl;
import product.sealights.evaluation.poc.demo.util.exceptions.InvalidInputException;
import product.sealights.evaluation.poc.demo.util.exceptions.NotFoundException;
import product.sealights.evaluation.poc.demo.util.http.ServiceUtil;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProductServiceImplTest {

    private ProductServiceImpl testObj;

    @Before
    public void setUp() {
        testObj = new ProductServiceImpl(new ServiceUtil("100"));
    }

    @Ignore
    @Test(expected = InvalidInputException.class)
    public void getProduct_throwsInvalidInputException() {
        testObj.getProduct(0);
    }

    @Test(expected = NotFoundException.class)
    public void getProduct_throwsNotFoundException() {
        testObj.getProduct(13);
    }

    @Test
    public void getProduct_returnsProduct() {
        final int productId = 1;
        Product product = testObj.getProduct(productId);
        assertTrue(product.getProductId() == productId);
    }
}
