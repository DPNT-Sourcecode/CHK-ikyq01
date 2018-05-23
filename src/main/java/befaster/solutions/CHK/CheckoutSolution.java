package befaster.solutions.CHK;

import java.util.List;

import befaster.solutions.CHK.offer.Offer;
import befaster.solutions.CHK.offer.OfferService;
import befaster.solutions.CHK.offer.OfferServiceImpl;
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
	private OfferService offerService = new OfferServiceImpl();
	
	/**
	 * Calculates the price for a given list of products, taking into account the offers currently available.
	 * 
	 * @param skus The single character product codes (Stock Keeping Units, or SKUs), concatenated into a string. 
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
    
   	private int calculatePrice(ShoppingCart cart) {
   		
   		// Apply any offers applicable to the products in the cart
   		List<Offer> offers = offerService.getOffers();
   		for (Offer offer : offers) {
			offer.applyOffers(cart);
		}
   		
    	// Add the basic prices
        for (Product product : cart.getChargeableProducts()) {
        	int count = cart.getCount(product);
        	cart.addToTotal(count * product.getBasePrice());
		}
        
        return cart.getTotal();
    }

}
