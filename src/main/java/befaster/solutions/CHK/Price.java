package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

import befaster.solutions.CHK.product.Product;

/**
 * The price of the products in a shopping cart, along with data used to apply offers.
 */
public class Price {
	
	private int total = 0;
	
	// Count of free items
    private final Map<Character, Integer> freeCounts = new HashMap<>();
    
    // Products counts, after group discounts have been applied
	private final Map<Character, Integer> productCounts = new HashMap<>();
	
	public Price(ShoppingCart cart) {
		this.productCounts.putAll(cart.getProductCounts());
	}
	
	public void addToTotal(int subTotal) {
		total += subTotal;
	}

	public int getTotal() {
		return total;
	}

	public Integer getFreeCount(Product product) {
		return freeCounts.get(product.getCode());
	}
	
	public Map<Character, Integer> getFreeCounts() {
		return freeCounts;
	}
	
	// TODO int vs Integer (product codes in GroupDiscountOffer may not appear in cart) 
	
	public int getCount(Product product) {
		return productCounts.get(product.getCode());
	}
	
	public Integer getCount(Character productCode) {
		return productCounts.get(productCode);
	}

	public Map<Character, Integer> getProductCounts() {
		return productCounts;
	}

}
