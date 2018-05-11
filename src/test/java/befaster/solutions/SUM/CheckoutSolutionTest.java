package befaster.solutions.SUM;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import befaster.solutions.CHK.CheckoutSolution;

public class CheckoutSolutionTest {
    private CheckoutSolution checkout;

    @Before
    public void setUp() {
    	checkout = new CheckoutSolution();
    }

    @Test
    public void compute_checkout() {
        assertThat(checkout.checkout("A"), equalTo(50));
    }
}
