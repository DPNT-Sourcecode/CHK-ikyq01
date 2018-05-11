package befaster.solutions.CHK;

/**
 * TODO Comments!
 * 
 * @author Name
 */
public class Price {
	
	private final int basePrice;
	private final Integer offerCount;
	private final Integer offerPrice;
	
	public Price(int basePrice) {
		this.basePrice = basePrice;
		this.offerCount = null;
		this.offerPrice = null;
	}
	
	public Price(int basePrice, Integer offerCount, Integer offerPrice) {
		this.basePrice = basePrice;
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public Integer getOfferCount() {
		return offerCount;
	}

	public Integer getOfferPrice() {
		return offerPrice;
	}
	
}
