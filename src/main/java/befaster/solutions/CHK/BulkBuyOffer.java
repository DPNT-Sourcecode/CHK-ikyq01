package befaster.solutions.CHK;

public class BulkBuyOffer {

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

}
