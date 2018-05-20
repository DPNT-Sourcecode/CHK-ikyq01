package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import befaster.solutions.CHK.product.Product;
import befaster.solutions.CHK.product.ProductService;
import befaster.solutions.CHK.product.ProductServiceImpl;
import befaster.solutions.CHK.product.UnknownProductException;

/**
 * A solution to a "shopping checkout" coding challenge.
 * 
 * TODO? Discuss coding standards regarding comments in code
 * 
 * @author A Name
 */
public class CheckoutSolution {
	
	private ProductService productService = new ProductServiceImpl();
	
	/**
	 * Calculates the price for a given list of products, taking into account the offers currently available.
	 * 
	 * @param skus The single character product codes, concatenated into a string. 
	 * @return The price for the products.
	 */
	public Integer checkout(String skus) {
    	
    	// Get a map from product code, to the number of that product in the shopping cart
        Map<Character, Integer> productCounts = productService.countProducts(skus);
        
		try {
			return calculatePrice(productCounts);
		} catch (UnknownProductException e) {
	        // NOTE: Required to return -1 if an invalid product code is found
			// TODO? Discuss Java logging solutions
			System.out.println("ERROR - " + e.getMessage());
			return -1;
		}
	}
        
   	private Integer calculatePrice(Map<Character, Integer> productCounts) throws UnknownProductException {
        
        // Get the products in the shopping cart (sorted so that the product with the largest base price is first) 
        List<Product> products = productService.getProducts(productCounts.keySet());
        
        // Compute number of free items
        Map<Character, Integer> freeCounts = new HashMap<Character, Integer>();
        for (Character code : productCounts.keySet()) {
        	int count = productCounts.get(code);
        	// TODO Retrieving products multiple times ...
			Product product = productService.getProduct(code);
			for (GetItemsFreeOffer offer : product.getGetItemsFreeOffers()) {
				
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
        // Requirement: "The policy of the supermarket is to always favor the customer when applying special offers."
        // NOTE: To fulfil this requirement, it is necessary to apply a GDO to the most expensive items first
        //       For simplicity, the current implementation only considers the base price of each item
		// TODO handling of overlapping group discounts
        Set<GroupDiscountOffer> gdos = getGroupDiscountOffers(products);
        for (GroupDiscountOffer offer : gdos) {
			// Count number of items in offer
        	int itemsInOffer = 0;
        	for (Character code : offer.getCodes()) {
            	Integer count = productCounts.get(code);
            	if (count != null) {
            		itemsInOffer += count;
            	}
        	}
        	
        	// Apply offer, starting with most expensive items
        	while (itemsInOffer >= offer.getOfferCount()) {
        		for (int i = 0; i < offer.getOfferCount(); i++) {
        			// TODO Optimise?
                	for (Product price : products) {
                		if (offer.getCodes().contains(price.getCode())) {
	                    	Integer count = productCounts.get(price.getCode());
	                    	if (count != null) {
	                    		if (count == 1) {
	                    			productCounts.remove(price.getCode());
	                    		} else {
	                    			--count;
	                    			productCounts.put(price.getCode(), count);
	                    		}
	                    		break;
	                    	}
                		}
                	}
				}
        		total += offer.getOfferPrice();
        		itemsInOffer -= offer.getOfferCount();
        	}
		}
        
    	// Add basic and bulk buy prices
        for (Character code : productCounts.keySet()) {
        	int count = productCounts.get(code); 
			Integer freeItemCount = freeCounts.get(code);
			if (freeItemCount != null) {
				count = count - freeItemCount;
				if (count <= 0) continue;
			}
        	// TODO Retrieving products multiple times ...
			Product product = productService.getProduct(code);
        	if (product.getBulkBuyOffers().isEmpty()) {
        		total += count * product.getBasePrice();
        	} else {
        		int remaining = count;
        		for (BulkBuyOffer offer : product.getBulkBuyOffers()) {
            		int offerPrice = (remaining / offer.getOfferCount()) * offer.getOfferPrice();
            		total += offerPrice;
            		remaining = remaining % offer.getOfferCount();
        		}
        		int basePrice = remaining * product.getBasePrice();
        		total += basePrice;
        	}
		}
        
        return total;
    }

	// TODO Move to offer service
	private Set<GroupDiscountOffer> getGroupDiscountOffers(List<Product> products) {
		
        Set<GroupDiscountOffer> offers = new HashSet<GroupDiscountOffer>();
		for (Product product : products) {
			if (product.getGroupDiscountOffer() != null) {
				offers.add(product.getGroupDiscountOffer());
			}
		}
        
        return offers;
	}
	
}
