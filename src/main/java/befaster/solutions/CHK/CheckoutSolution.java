package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
	
	private static final Map<Character, Price> prices = new HashMap<Character, Price>();
	static {
		List<BulkBuyOffer> bulkBuyOffers = new ArrayList<BulkBuyOffer>();
		bulkBuyOffers.add(new BulkBuyOffer(3, 130));
		bulkBuyOffers.add(new BulkBuyOffer(5, 200));
		prices.put('A', new Price(50, bulkBuyOffers));
		
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

//  Our price table and offers: 
//	+------+-------+------------------------+
//	| Item | Price | Special offers         |
//	+------+-------+------------------------+
//	| A    | 50    | 3A for 130, 5A for 200 |
//	| B    | 30    | 2B for 45              |
//	| C    | 20    |                        |
//	| D    | 15    |                        |
//	| E    | 40    | 2E get one B free      |
//	| F    | 10    | 2F get one F free      |
//	+------+-------+------------------------+
	
    public Integer checkout(String skus) {
    	
    	// TODO Convert to upper case?
    	
    	// Count each code
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
        
        // Check each code has a price, and sort bulk buy offers
        for (Character code : counts.keySet()) {
			Price price = prices.get(code);
			if (price == null) {
				// TODO Logging
				System.out.println("Unknown code: " + code);
//				continue;
				return -1;
			}
			Collections.sort(price.getBulkBuyOffers());
        }
        
        // Compute number of free items
        Map<Character, Integer> freeCounts = new HashMap<Character, Integer>();
        for (Character code : counts.keySet()) {
        	int count = counts.get(code); 
			Price price = prices.get(code);
			for (GetItemsFreeOffer offer : price.getGetItemsFreeOffers()) {
				
        		int freeItemCount = (count / offer.getOfferCount()) * offer.getItemCount();
    			Integer totalFreeItemCount = freeCounts.get(offer.getOfferCode());
    			if (totalFreeItemCount == null) {
    				totalFreeItemCount = freeItemCount;
    			} else {
    				totalFreeItemCount += freeItemCount;
    			}
    			freeCounts.put(offer.getOfferCode(), totalFreeItemCount);
    		}
		}
        
        // TODO This does not test for "circular" offers
        // c.f. "All the offers are well balanced so that they can be safely combined."
        
    	// Compute total cost
        int total = 0;
        for (Character code : counts.keySet()) {
        	int count = counts.get(code); 
			Integer freeItemCount = freeCounts.get(code);
			if (freeItemCount != null) {
				count = count - freeItemCount;
				if (count <= 0) continue;
			}
			Price price = prices.get(code);
        	if (price.getBulkBuyOffers().isEmpty()) {
        		total += count * price.getBasePrice();
        	} else {
        		int remaining = count;
        		for (BulkBuyOffer offer : price.getBulkBuyOffers()) {
            		int offerPrice = (remaining / offer.getOfferCount()) * offer.getOfferPrice();
            		total += offerPrice;
            		remaining = remaining % offer.getOfferCount();
        		}
        		int basePrice = remaining * price.getBasePrice();
        		total += basePrice;
        	}
		}
        
        return total;
    }

}
