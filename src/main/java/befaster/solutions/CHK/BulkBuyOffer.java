package befaster.solutions.CHK;

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

	@Override
	public int compareTo(BulkBuyOffer offer) {
		return offer.offerCount - this.offerCount;
	}

}
