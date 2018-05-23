package befaster.solutions.CHK.offer;

import java.util.HashSet;
import java.util.Set;

import befaster.solutions.CHK.ShoppingCart;
import befaster.solutions.CHK.product.Product;

/**
 * A special offer, in which multiple products from a specified group of product types, are presented at a reduced price.
 *
 * NOTE: Introduced in CHK_R5
 */
public class GroupDiscountOffer implements Offer {

	protected static final GroupDiscountOffer SINGLETON = new GroupDiscountOffer();

	private int numberOfProducts;
	private int offerPrice;
	private Set<Character> productCodes = new HashSet<Character>();

	private GroupDiscountOffer() {};

	public GroupDiscountOffer(int numberOfProducts, int offerPrice, Set<Character> productCodes) {
		this.numberOfProducts = numberOfProducts;
		this.offerPrice = offerPrice;
		this.productCodes.addAll(productCodes);
	}

	// Requirement: "The policy of the supermarket is to always favor the customer when applying special offers."
	// NOTE: To fulfil this requirement, it is necessary to apply a GDO to the most expensive items first
	//       For simplicity, the current implementation only considers the base price of each item
	public void applyOffers(ShoppingCart cart) {

		Set<GroupDiscountOffer> offers = getGroupDiscountOffers(cart);
		for (GroupDiscountOffer offer : offers) {
			applyOffer(offer, cart);
		}
	}

	private Set<GroupDiscountOffer> getGroupDiscountOffers(ShoppingCart cart) {

		Set<GroupDiscountOffer> offers = new HashSet<GroupDiscountOffer>();
		for (Product product : cart.getProducts()) {
			if (product.getGroupDiscountOffer() != null) {
				offers.add(product.getGroupDiscountOffer());
			}
		}
		return offers;
	}

	private void applyOffer(GroupDiscountOffer offer, ShoppingCart cart) {

		// Count the number of products in the cart which are in the offer
		int productsInOffer = countProductsInOffer(offer, cart);

		// Apply the offer, starting with most expensive products
		while (productsInOffer >= offer.numberOfProducts) {
			for (int i = 0; i < offer.numberOfProducts; i++) {
				handleNext(offer, cart);
			}
			cart.addToTotal(offer.offerPrice);
			productsInOffer -= offer.numberOfProducts;
		}
	}

	private void handleNext(GroupDiscountOffer offer, ShoppingCart cart) {

		for (Product product : cart.getProducts()) {
			if (applyForProduct(offer, cart, product)) return;
		}
	}

	// Returns true if the offer was applied to the product
	private boolean applyForProduct(GroupDiscountOffer offer, ShoppingCart cart, Product product) {

		if (offer.productCodes.contains(product.getCode())) {
			int count = cart.getCount(product);
			if (count != 0) {
				--count;
				cart.getProductCounts().put(product.getCode(), count);
				return true;
			}
		}
		return false;
	}

	private int countProductsInOffer(GroupDiscountOffer offer, ShoppingCart cart) {

		int productsInOffer = 0;
		for (Character code : offer.productCodes) {
			Integer count = cart.getCount(code);
			if (count != null) {
				productsInOffer += count;
			}
		}
		return productsInOffer;
	}

	public boolean equals(Object object) {

		if (object == null) return false;
		if (this == object) return true;
		if (object instanceof GroupDiscountOffer) {
			GroupDiscountOffer offer = (GroupDiscountOffer) object;
			return
				offer.numberOfProducts == this.numberOfProducts &&
				offer.offerPrice == this.offerPrice &&
				offer.productCodes.equals(this.productCodes);
		}
		return false;
	}

}
