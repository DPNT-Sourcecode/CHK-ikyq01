package befaster.solutions.CHK;

public class BulkBuyOffer implements Comparable<BulkBuyOffer> {

	private final int offerCount;
	private final int offerPrice;
	
	public BulkBuyOffer(int offerCount, int offerPrice) {
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
	}
	
	public Integer getOfferCount() {
		return offerCount;
	}

	public Integer getOfferPrice() {
		return offerPrice;
	}

	@Override
	public int compareTo(BulkBuyOffer offer) {
		return this.offerCount - offer.offerCount;
	}

}
