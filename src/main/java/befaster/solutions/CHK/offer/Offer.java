package befaster.solutions.CHK.offer;

import befaster.solutions.CHK.ShoppingCart;

/**
 * A special offer.
 * 
 * NOTE from CHK_R2: "The policy of the supermarket is to always favor the customer when applying special offers."
 */
public interface Offer {

	/**
	 * Applies all instances of this offer to the given shopping cart.
	 * 
	 * NOTE: The order in which offers are applied may be significant. 
	 */
	public void applyOffers(ShoppingCart cart);
	
}
