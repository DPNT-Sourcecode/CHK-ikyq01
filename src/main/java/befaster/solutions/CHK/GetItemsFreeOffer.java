package befaster.solutions.CHK;

// TODO Generalise to get 'n' free
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
