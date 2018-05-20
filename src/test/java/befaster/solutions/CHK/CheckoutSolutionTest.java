package befaster.solutions.CHK;

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
    
//	Our price table and offers: 
//	+------+-------+---------------------------------+
//	| Item | Price | Special offers                  |
//	+------+-------+---------------------------------+
//	| A    | 50    | 3A for 130, 5A for 200          |
//	| B    | 30    | 2B for 45                       |
//	| C    | 20    |                                 |
//	| D    | 15    |                                 |
//	| E    | 40    | 2E get one B free               |
//	| F    | 10    | 2F get one F free               |
//	| G    | 20    |                                 |
//	| H    | 10    | 5H for 45, 10H for 80           |
//	| I    | 35    |                                 |
//	| J    | 60    |                                 |
//	| K    | 70    | 2K for 120                      |
//	| L    | 90    |                                 |
//	| M    | 15    |                                 |
//	| N    | 40    | 3N get one M free               |
//	| O    | 10    |                                 |
//	| P    | 50    | 5P for 200                      |
//	| Q    | 30    | 3Q for 80                       |
//	| R    | 50    | 3R get one Q free               |
//	| S    | 20    | buy any 3 of (S,T,X,Y,Z) for 45 |
//	| T    | 20    | buy any 3 of (S,T,X,Y,Z) for 45 |
//	| U    | 40    | 3U get one U free               |
//	| V    | 50    | 2V for 90, 3V for 130           |
//	| W    | 20    |                                 |
//	| X    | 17    | buy any 3 of (S,T,X,Y,Z) for 45 |
//	| Y    | 20    | buy any 3 of (S,T,X,Y,Z) for 45 |
//	| Z    | 21    | buy any 3 of (S,T,X,Y,Z) for 45 |
//	+------+-------+---------------------------------+

    @Test
    public void compute_gdo() {

        assertThat(checkout.checkout("STX"), equalTo(45));
        assertThat(checkout.checkout("STXSTX"), equalTo(90));
        assertThat(checkout.checkout("STXS"), equalTo(62));
        assertThat(checkout.checkout("STZS"), equalTo(65));
        
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRUVW"), equalTo(755));
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRUVWSTX"), equalTo(800));
        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(1602));
        assertThat(checkout.checkout("LGCKAQXFOSKZGIWHNRNDITVBUUEOZXPYAVFDEPTBMQLYJRSMJCWH"), equalTo(1602));
        assertThat(checkout.checkout("AAAAAPPPPPUUUUEEBRRRQAAAHHHHHHHHHHKKVVVBBNNNMFFFQQQVVHHHHHSTX"), equalTo(1655));
    }
    
    @Test
    public void compute_checkout() {
    	
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
//        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(965));
//        assertThat(checkout.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(1880));

        assertThat(checkout.checkout("Aa"), equalTo(-1));
    }
}
