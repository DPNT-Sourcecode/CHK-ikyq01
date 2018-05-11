package befaster.solutions.SUM;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import befaster.solutions.CHK.CheckoutSolution;

public class CheckoutSolutionTest {
    private CheckoutSolution hello;

    @Before
    public void setUp() {
    	hello = new CheckoutSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(hello.checkout("A"), equalTo(50));
    }
}
