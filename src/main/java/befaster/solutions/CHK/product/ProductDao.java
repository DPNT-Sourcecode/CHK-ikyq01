package befaster.solutions.CHK.product;

public interface ProductDao {

	/**
	 * Gets the product with the given code.
	 * 
	 * @return The product, or null if none exists with the given code.
	 */
	Product getProduct(char code);

}
