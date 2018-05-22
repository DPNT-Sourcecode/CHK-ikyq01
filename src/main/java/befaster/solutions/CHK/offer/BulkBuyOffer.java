package befaster.solutions.CHK.offer;

import befaster.solutions.CHK.ShoppingCart;
import befaster.solutions.CHK.product.Product;

public class BulkBuyOffer implements Offer, Comparable<BulkBuyOffer> {

	protected static final BulkBuyOffer SINGLETON = new BulkBuyOffer();

	private int offerCount;
	private int offerPrice;
	
	private BulkBuyOffer() {};
	
	public BulkBuyOffer(int offerCount, int offerPrice) {
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
	}

	public void applyOffers(ShoppingCart cart) {
        for (Product product : cart.getChargeableProducts()) {
        	if (!product.getBulkBuyOffers().isEmpty()) {
        		applyOffer(cart, product);
        	}
		}
	}
	
	private void applyOffer(ShoppingCart cart, Product product) {
		int remaining = cart.getCount(product);
		for (BulkBuyOffer offer : product.getBulkBuyOffers()) {
    		int offerPrice = (remaining / offer.getOfferCount()) * offer.getOfferPrice();
    		cart.addToTotal(offerPrice);
    		remaining = remaining % offer.getOfferCount();
		}
		int basePrice = remaining * product.getBasePrice();
		cart.addToTotal(basePrice);
		cart.getProductCounts().put(product.getCode(), 0);
	}
	
	@Override
	public int compareTo(BulkBuyOffer offer) {
		return offer.offerCount - this.offerCount;
	}
	
	public int getOfferCount() {
		return offerCount;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

}
