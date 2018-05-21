package befaster.solutions.CHK.product;

import befaster.solutions.CHK.ShoppingCart;

public interface ProductService {

	/**
	 * Gets the product with the given code.
	 */
	Product getProduct(char code) throws UnknownProductException;

	/**
	 * Gets a shopping cart, containing the given products.
	 * 
	 * @param productCodes The product code characters, concatenated into a single string. 
	 */
	ShoppingCart getShoppingCart(String productCodes) throws UnknownProductException;

}
