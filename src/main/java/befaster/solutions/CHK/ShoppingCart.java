package befaster.solutions.CHK;

import java.util.List;
import java.util.Map;
import java.util.Set;

import befaster.solutions.CHK.product.Product;

/**
 * A list of products to purchase.
 * 
 * NOTE: The product counts given are the total counts, before any offers have been applied.
 */
public class ShoppingCart {
	
	private final List<Product> products;
	private final Set<Character> productCodes;
	private final Map<Character, Integer> productCounts;
	
	public ShoppingCart(List<Product> products, Set<Character> productCodes, Map<Character, Integer> productCounts) {
		this.products = products;
		this.productCodes = productCodes;
		this.productCounts = productCounts;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public Set<Character> getProductCodes() {
		return productCodes;
	}

	public Map<Character, Integer> getProductCounts() {
		return productCounts;
	}
	
}
