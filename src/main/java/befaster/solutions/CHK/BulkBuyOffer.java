package befaster.solutions.CHK;

import befaster.solutions.CHK.product.Product;

public class BulkBuyOffer implements Comparable<BulkBuyOffer> {

	private final int offerCount;
	private final int offerPrice;
	
	public BulkBuyOffer(int offerCount, int offerPrice) {
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
	}
	
	public int getOfferCount() {
		return offerCount;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

	public static void applyOffers(ShoppingCart cart) {
        for (Product product : cart.getChargeableProducts()) {
        	
        	int count = cart.getCount(product);
        	if (!product.getBulkBuyOffers().isEmpty()) {
        		int remaining = count;
        		for (BulkBuyOffer offer : product.getBulkBuyOffers()) {
            		int offerPrice = (remaining / offer.getOfferCount()) * offer.getOfferPrice();
            		cart.addToTotal(offerPrice);
            		remaining = remaining % offer.getOfferCount();
        		}
        		int basePrice = remaining * product.getBasePrice();
        		cart.addToTotal(basePrice);
        		cart.getProductCounts().put(product.getCode(), 0);
        	}
		}
		
	}
	
	@Override
	public int compareTo(BulkBuyOffer offer) {
		return offer.offerCount - this.offerCount;
	}

}
