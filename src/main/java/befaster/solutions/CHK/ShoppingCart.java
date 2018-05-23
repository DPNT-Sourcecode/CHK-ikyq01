package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import befaster.solutions.CHK.product.Product;

/**
 * A list of products to purchase.
 */
public class ShoppingCart {

	private final List<Product> products;

	// The number of each type of product in the cart
	// NOTE: These counts may be modified when special offers are applied
	private final Map<Character, Integer> productCounts;

	// The total price for the products
	private int total = 0;

	public ShoppingCart(List<Product> products, Map<Character, Integer> productCounts) {
		this.products = products;
		this.productCounts = productCounts;
	}

	/**
	 * Gets all the products in the cart.
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Gets just those products in the cart which remain chargeable, after special offers have been applied.
	 */
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

	public Map<Character, Integer> getProductCounts() {
		return productCounts;
	}

	public Integer getCount(Product product) {
		return getCount(product.getCode());
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
