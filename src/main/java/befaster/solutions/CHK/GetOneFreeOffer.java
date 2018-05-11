package befaster.solutions.CHK;

// TODO Generalise to get 'n' free
public class GetOneFreeOffer {

	private final int offerCount;
	private final char offerCode;
	
	public GetOneFreeOffer(int offerCount, char offerCode) {
		this.offerCount = offerCount;
		this.offerCode = offerCode;
	}
	
	public int getOfferCount() {
		return offerCount;
	}

	public char getOfferCode() {
		return offerCode;
	}

}
