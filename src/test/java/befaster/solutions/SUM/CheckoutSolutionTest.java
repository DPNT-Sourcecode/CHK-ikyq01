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

//    Our price table and offers: 
//    	+------+-------+------------------------+
//    	| Item | Price | Special offers         |
//    	+------+-------+------------------------+
//    	| A    | 50    | 3A for 130, 5A for 200 |
//    	| B    | 30    | 2B for 45              |
//    	| C    | 20    |                        |
//    	| D    | 15    |                        |
//    	| E    | 40    | 2E get one B free      |
//    	| F    | 10    | 2F get one F free      |
//    	+------+-------+------------------------+
    
    
    @Test
    public void compute_checkout() {
    	
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(1880));
    	
        assertThat(checkout.checkout("A"), equalTo(50));
        assertThat(checkout.checkout("AA"), equalTo(100));
        assertThat(checkout.checkout("AAA"), equalTo(130));
        assertThat(checkout.checkout("AAAA"), equalTo(180));
        assertThat(checkout.checkout("ABCD"), equalTo(115));
        assertThat(checkout.checkout("E"), equalTo(40));
        assertThat(checkout.checkout("EE"), equalTo(80));
        assertThat(checkout.checkout("EEB"), equalTo(80));
        assertThat(checkout.checkout("EEBB"), equalTo(110));
        assertThat(checkout.checkout("EEEEBB"), equalTo(160));
        
        assertThat(checkout.checkout("AAAAA"), equalTo(200));
        assertThat(checkout.checkout("AAAAAA"), equalTo(250));
        assertThat(checkout.checkout("AAAAAAA"), equalTo(300));
        assertThat(checkout.checkout("AAAAAAAA"), equalTo(330));
        assertThat(checkout.checkout("AAAAAAAAA"), equalTo(380));
        
        assertThat(checkout.checkout("F"), equalTo(10));
        assertThat(checkout.checkout("FF"), equalTo(20));
        assertThat(checkout.checkout("FFF"), equalTo(20));
        assertThat(checkout.checkout("FFFF"), equalTo(30));
        assertThat(checkout.checkout("FFFFF"), equalTo(40));
        assertThat(checkout.checkout("FFFFFF"), equalTo(40));
        assertThat(checkout.checkout("FFFFFFF"), equalTo(50));

        assertThat(checkout.checkout("O"), equalTo(10));
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(965));
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(1880));
        
        assertThat(checkout.checkout("Aa"), equalTo(-1));
    }
}
