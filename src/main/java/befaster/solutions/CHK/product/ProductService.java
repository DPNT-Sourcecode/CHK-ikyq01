package befaster.solutions.CHK.product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

	/**
	 * Counts the number of times each product code occurs in the given string.
	 * 
	 * @param productCodes The product code characters, concatenated into a single string. 
	 * @return A Map from product codes, to the number of instances in the given string. 
	 */
	Map<Character, Integer> countProducts(String productCodes);

	/**
	 * Gets the product with the given code.
	 */
	Product getProduct(char code) throws UnknownProductException;

	/**
	 * Get the products with the given codes, sorted so that the product with the largest base price is first. 
	 */
	List<Product> getProducts(Set<Character> productCodes) throws UnknownProductException;

}
