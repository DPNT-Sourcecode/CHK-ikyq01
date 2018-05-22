package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import befaster.solutions.CHK.product.Product;

/**
 * A list of products to purchase.
 */
public class ShoppingCart {
	
	private final List<Product> products;
	private final Set<Character> productCodes;
	private final Map<Character, Integer> productCounts;
	
	private int total = 0;
	
	public ShoppingCart(List<Product> products, Set<Character> productCodes, Map<Character, Integer> productCounts) {
		this.products = products;
		this.productCodes = productCodes;
		this.productCounts = productCounts;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public List<Product> getChargeableProducts() {
        List<Product> chargeableProducts = new ArrayList<Product>();
        for (Product product : products) {
        	int count = getCount(product);
        	if (count > 0) {
        		chargeableProducts.add(product);
        	}
        }
		return chargeableProducts;
	}
	
	public Set<Character> getProductCodes() {
		return productCodes;
	}

	public Map<Character, Integer> getProductCounts() {
		return productCounts;
	}
	
	// TODO int vs Integer (product codes in GroupDiscountOffer may not appear in cart) 
	
	public int getCount(Product product) {
		return productCounts.get(product.getCode());
	}
	
	public Integer getCount(Character productCode) {
		return productCounts.get(productCode);
	}

	public void addToTotal(int subTotal) {
		total += subTotal;
	}

	public int getTotal() {
		return total;
	}
	
}
