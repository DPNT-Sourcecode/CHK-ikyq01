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

//	Our price table and offers: 
//	+------+-------+----------------+
//	| Item | Price | Special offers |
//	+------+-------+----------------+
//	| A    | 50    | 3A for 130     |
//	| B    | 30    | 2B for 45      |
//	| C    | 20    |                |
//	| D    | 15    |                |
//	+------+-------+----------------+

//	Our price table and offers: 
//		+------+-------+------------------------+
//		| Item | Price | Special offers         |
//		+------+-------+------------------------+
//		| A    | 50    | 3A for 130, 5A for 200 |
//		| B    | 30    | 2B for 45              |
//		| C    | 20    |                        |
//		| D    | 15    |                        |
//		| E    | 40    | 2E get one B free      |
//		+------+-------+------------------------+

    @Test
    public void compute_checkout() {
//        assertThat(checkout.checkout("A"), equalTo(50));
//        assertThat(checkout.checkout("AA"), equalTo(100));
//        assertThat(checkout.checkout("AAA"), equalTo(130));
//        assertThat(checkout.checkout("AAAA"), equalTo(180));
//        assertThat(checkout.checkout("ABCD"), equalTo(115));
//        assertThat(checkout.checkout("E"), equalTo(40));
        assertThat(checkout.checkout("EE"), equalTo(80));
        assertThat(checkout.checkout("EEB"), equalTo(80));
        assertThat(checkout.checkout("ABCDEF"), equalTo(-1));
    }
}
