package befaster.solutions.CHK;

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
		ShoppingCart cart;
		try {
			cart = productService.getShoppingCart(skus);
		} catch (UnknownProductException e) {
	        // NOTE: Required to return -1 if an invalid product code is found
			// TODO? Discuss Java logging solutions
			System.out.println("ERROR - " + e.getMessage());
			return -1;
		}

		return calculatePrice(cart);
	}
    
	// TODO Explore issue of offer conflicts
   	private Integer calculatePrice(ShoppingCart cart) {
   		
        // TODO Create offer interface, and refactor
   		GetItemsFreeOffer.applyOffers(cart); // NOTE: must be done first
        BulkBuyOffer.applyOffers(cart);
        GroupDiscountOffer.applyOffers(cart);
        
    	// Add basic prices
        for (Product product : cart.getChargeableProducts()) {
        	int count = cart.getCount(product);
        	cart.addToTotal(count * product.getBasePrice());
		}
        
        return cart.getTotal();
    }

}
