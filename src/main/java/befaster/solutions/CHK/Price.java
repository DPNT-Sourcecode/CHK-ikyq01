package befaster.solutions.CHK;

/**
 * TODO Comments!
 * 
 * @author Name
 */
public class Price {
	
	private final int basePrice;
	
	private final Integer offerCount;
	// If the offer count is reached, either the offerPrice is charged, or a unit with the given offer code is given free
	// (current implementation assumes only a single item will be given free)
	private final Integer offerPrice;
	private final Character offerCode;
	
	public Price(int basePrice) {
		this.basePrice = basePrice;
		this.offerCount = null;
		this.offerPrice = null;
		this.offerCode = null;
	}
	
	public Price(int basePrice, Integer offerCount, Integer offerPrice) {
		this.basePrice = basePrice;
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
		this.offerCode = null;
	}
	
	public Price(int basePrice, Integer offerCount, Character offerCode) {
		this.basePrice = basePrice;
		this.offerCount = offerCount;
		this.offerPrice = null;
		this.offerCode = offerCode;
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

	public Character getOfferCode() {
		return offerCode;
	}
	
}
