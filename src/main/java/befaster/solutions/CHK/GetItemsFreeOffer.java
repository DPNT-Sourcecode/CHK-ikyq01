package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

import befaster.solutions.CHK.product.Product;

public class GetItemsFreeOffer {

	private final int offerCount;
	private final char offerCode;
	private final int itemCount;
	
	public GetItemsFreeOffer(int offerCount, char offerCode) {
		this.offerCount = offerCount;
		this.offerCode = offerCode;
		this.itemCount = 1;
	}
	
	public GetItemsFreeOffer(int offerCount, char offerCode, int itemCount) {
		this.offerCount = offerCount;
		this.offerCode = offerCode;
		this.itemCount = itemCount;
	}

	// TODO static
	public static void applyOffers(ShoppingCart cart) {
		
		// Count of free items
		Map<Character, Integer> freeCounts = new HashMap<>();
	    
		for (Product product : cart.getProducts()) {
        	int count = cart.getCount(product);
			for (GetItemsFreeOffer offer : product.getGetItemsFreeOffers()) {
        		count = applyOffer(freeCounts, offer, count);
    		}
		}

        // TODO Review
        for (Product product : cart.getProducts()) {
        	int count = cart.getCount(product);
			Integer freeItemCount = freeCounts.get(product.getCode());
			if (freeItemCount != null) {
				count = count - freeItemCount;
				if (count <= 0) count = 0;
				cart.getProductCounts().put(product.getCode(), count);
			}
        }
	}
	
	// TODO static
	private static int applyOffer(Map<Character, Integer> freeCounts, GetItemsFreeOffer offer, int count) {
		
		int freeItemCount = (count / offer.getOfferCount()) * offer.getItemCount();
		Integer totalFreeItemCount = freeCounts.get(offer.getOfferCode());
		if (totalFreeItemCount == null) {
			totalFreeItemCount = freeItemCount;
		} else {
			totalFreeItemCount += freeItemCount;
		}
		freeCounts.put(offer.getOfferCode(), totalFreeItemCount);
		return count;
	}
	
	public int getOfferCount() {
		return offerCount;
	}

	public char getOfferCode() {
		return offerCode;
	}
	
	public int getItemCount() {
		return itemCount;
	}

}
