package befaster.solutions.CHK.offer;

import befaster.solutions.CHK.ShoppingCart;
import befaster.solutions.CHK.product.Product;

/**
 * A special offer, in which multiple instances of a given product are presented at a reduced price.
 * 
 * Multiple bulk-buy offers may apply to a given product. In this case the offers are applied in order, starting with 
 * the offer applicable to the largest number of items. 
 * 
 * NOTE: Introduced in CHK_R1 - "some items are multi-priced: buy n of them, and they'll cost you y pounds"
 */
public class BulkBuyOffer implements Offer, Comparable<BulkBuyOffer> {

	protected static final BulkBuyOffer SINGLETON = new BulkBuyOffer();

	private int numberOfItems;
	private int offerPrice;
	
	private BulkBuyOffer() {};
	
	public BulkBuyOffer(int numberOfItems, int offerPrice) {
		this.numberOfItems = numberOfItems;
		this.offerPrice = offerPrice;
	}

	public void applyOffers(ShoppingCart cart) {
        for (Product product : cart.getChargeableProducts()) {
        	if (!product.getBulkBuyOffers().isEmpty()) {
        		applyOffers(cart, product);
        	}
		}
	}
	
	private void applyOffers(ShoppingCart cart, Product product) {
		int count = cart.getCount(product);
		// Apply the offers, starting with that applicable to the largest number of items
		for (BulkBuyOffer offer : product.getBulkBuyOffers()) {
    		int offerPrice = (count / offer.getNumberOfItems()) * offer.getOfferPrice();
    		cart.addToTotal(offerPrice);
    		count = count % offer.getNumberOfItems();
		}
		int basePrice = count * product.getBasePrice();
		cart.addToTotal(basePrice);
		cart.getProductCounts().put(product.getCode(), 0);
	}
	
	@Override
	public int compareTo(BulkBuyOffer offer) {
		return offer.numberOfItems - this.numberOfItems;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

}
