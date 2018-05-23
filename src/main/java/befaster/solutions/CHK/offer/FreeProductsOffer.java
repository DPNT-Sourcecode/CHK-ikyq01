package befaster.solutions.CHK.offer;

import java.util.HashMap;
import java.util.Map;

import befaster.solutions.CHK.ShoppingCart;
import befaster.solutions.CHK.product.Product;

/**
 * A special offer, in which some products of one type are free, if some other products of another type are purchased.
 *
 * TODO? This implementation is more general than necessary
 *       Each product has at most one offer of this type, and the number of free products is always 1
 *       Would a more restricted implementation be preferable?
 *
 * NOTE: This offer needs to be applied first
 * NOTE: Introduced in CHK_R2
 */
public class FreeProductsOffer implements Offer {

	protected static final FreeProductsOffer SINGLETON = new FreeProductsOffer();

	private int numberOfChargedProducts;
	private int numberOfFreeProducts;
	private char freeProductCode;

	private FreeProductsOffer() {};

	public FreeProductsOffer(int numberOfChargedProducts, int numberOfFreeProducts, char freeProductCode) {
		this.numberOfChargedProducts = numberOfChargedProducts;
		this.numberOfFreeProducts = numberOfFreeProducts;
		this.freeProductCode = freeProductCode;
	}

	public void applyOffers(ShoppingCart cart) {

		// Count the number of free products
		// NOTE: As this offer must be applied first, we can call getProducts() rather than getChargeableProducts()
		Map<Character, Integer> freeProductCounts = new HashMap<>();
		for (Product product : cart.getProducts()) {
			int count = cart.getCount(product);
			for (FreeProductsOffer offer : product.getFreeProductsOffers()) {
				count = countFreeProducts(freeProductCounts, offer, count);
			}
		}

		// Update the product counts on the cart
		for (Product product : cart.getProducts()) {
			updateCart(cart, product, freeProductCounts);
		}
	}

	private int countFreeProducts(Map<Character, Integer> freeProductCounts, FreeProductsOffer offer, int count) {

		int freeProductCount = (count / offer.numberOfChargedProducts) * offer.numberOfFreeProducts;
		Integer totalFreeProductCount = freeProductCounts.get(offer.freeProductCode);
		if (totalFreeProductCount == null) {
			totalFreeProductCount = freeProductCount;
		} else {
			totalFreeProductCount += freeProductCount;
		}
		freeProductCounts.put(offer.freeProductCode, totalFreeProductCount);
		return count;
	}

	private void updateCart(ShoppingCart cart, Product product, Map<Character, Integer> freeProductCounts) {

		int count = cart.getCount(product);
		Integer freeProductCount = freeProductCounts.get(product.getCode());
		if (freeProductCount != null) {
			count = count - freeProductCount;
			if (count <= 0) count = 0;
			cart.getProductCounts().put(product.getCode(), count);
		}
	}

}
