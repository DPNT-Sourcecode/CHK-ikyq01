package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
	
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
        
        // Check each code has a price, get list of prices, and sort bulk buy offers
        List<Price> prices = new ArrayList<Price>();
        for (Character code : counts.keySet()) {
			Price price = Prices.getPrice(code);
			if (price == null) {
				// TODO Logging
				System.out.println("Unknown code: " + code);
//				continue;
				return -1;
			}
			Collections.sort(price.getBulkBuyOffers());
			prices.add(price);
        }
		Collections.sort(prices);
        
        // Compute number of free items
        Map<Character, Integer> freeCounts = new HashMap<Character, Integer>();
        for (Character code : counts.keySet()) {
        	int count = counts.get(code); 
			Price price = Prices.getPrice(code);
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
        
        
        int total = 0;
        
        // Apply group discount offers
        
        // TODO for ...
        GroupDiscountOffer gdo = new GroupDiscountOffer(null, 0);
        // Requirement: "The policy of the supermarket is to always favor the customer when applying special offers."
        // NOTE: To fulfil this requirement, it is necessary to apply a GDO to the most expensive items first
        //       For simplicity, the current implementation only considers the base price of each item
        
        
        
    	// Add basic and bulk buy prices
        for (Character code : counts.keySet()) {
        	int count = counts.get(code); 
			Integer freeItemCount = freeCounts.get(code);
			if (freeItemCount != null) {
				count = count - freeItemCount;
				if (count <= 0) continue;
			}
			Price price = Prices.getPrice(code);
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
