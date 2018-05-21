package befaster.solutions.CHK;

import befaster.solutions.CHK.product.Product;

public class GetItemsFreeOffer {

	private final int offerCount;
	private final char offerCode;
	private final int itemCount;
	
	public GetItemsFreeOffer(int offerCount, char offerCode) {
		this.offerCount = offerCount;
		this.offerCode = offerCode;
		this.itemCount = 1;
	}
	
	public GetItemsFreeOffer(int offerCount, char offerCode, int itemCount) {
		this.offerCount = offerCount;
		this.offerCode = offerCode;
		this.itemCount = itemCount;
	}

	// TODO static
	public static void applyOffers(ShoppingCart cart, Price price) {
		
        for (Product product : cart.getProducts()) {
        	int count = price.getCount(product);
			for (GetItemsFreeOffer offer : product.getGetItemsFreeOffers()) {
				
        		int freeItemCount = (count / offer.getOfferCount()) * offer.getItemCount();
    			Integer totalFreeItemCount = price.getFreeCounts().get(offer.getOfferCode());
    			if (totalFreeItemCount == null) {
    				totalFreeItemCount = freeItemCount;
    			} else {
    				totalFreeItemCount += freeItemCount;
    			}
    			price.getFreeCounts().put(offer.getOfferCode(), totalFreeItemCount);
    		}
		}
	}
	
	public int getOfferCount() {
		return offerCount;
	}

	public char getOfferCode() {
		return offerCode;
	}
	
	public int getItemCount() {
		return itemCount;
	}

}
