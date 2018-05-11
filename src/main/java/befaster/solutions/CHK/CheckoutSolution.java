package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
	
	private static final Map<Character, Price> prices = new HashMap<Character, Price>();
	static {
		prices.put('A', new Price(50, 3, 130));
		prices.put('B', new Price(30, 2, 45));
		prices.put('C', new Price(20));
		prices.put('D', new Price(15));
		prices.put('E', new Price(40, 2, 'B'));
	}

//	Our price table and offers: 
//		+------+-------+----------------+
//		| Item | Price | Special offers |
//		+------+-------+----------------+
//		| A    | 50    | 3A for 130     |
//		| B    | 30    | 2B for 45      |
//		| C    | 20    |                |
//		| D    | 15    |                |
//		+------+-------+----------------+

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

	
    public Integer checkout(String skus) {
    	
    	// TODO Convert to upper case?
    	
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
    	char[] codes = skus.toCharArray();
        for (char code : codes) {
			Integer count = counts.get(code);
			if (count == null) {
				count = 1;
			} else {
				++count;
			}
			counts.put(code, count);
		}
        
        Map<Character, Integer> freeCounts = new HashMap<Character, Integer>();
        for (Character code : counts.keySet()) {
        	int count = counts.get(code); 
			Price price = prices.get(code);
			if (price == null) {
				// TODO Logging
				System.out.println("Unknown code: " + code);
//				continue;
				return -1;
			}
    		if (price.getOfferCode() == null) {
        		int basePrice = (count % price.getOfferCount()) * price.getBasePrice();
        		int offerPrice = (count / price.getOfferCount()) * price.getOfferPrice();
        		total += basePrice;
        		total += offerPrice;
    		}
		}
        
    	int total = 0;
        for (Character code : counts.keySet()) {
        	int count = counts.get(code); 
			Price price = prices.get(code);
        	if (price.getOfferCount() == null) {
        		total += count * price.getBasePrice();
        	} else {
        		if (price.getOfferCode() == null) {
	        		int basePrice = (count % price.getOfferCount()) * price.getBasePrice();
	        		int offerPrice = (count / price.getOfferCount()) * price.getOfferPrice();
	        		total += basePrice;
	        		total += offerPrice;
        		} else {
        		}
        	}
		}
        
        return total;
    }

}
