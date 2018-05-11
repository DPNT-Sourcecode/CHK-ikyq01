package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Comments!
 * 
 * @author Name
 */
public class Price {
	
	private final int basePrice;
	
	private final List<MultiBuy> multiBuys = new ArrayList<MultiBuy>();
	private final Character offerCode;
	
	public Price(int basePrice) {
		this.basePrice = basePrice;
		this.offerCode = null;
	}
	
	public Price(int basePrice, Integer offerCount, Integer offerPrice) {
		this.basePrice = basePrice;
		multiBuys.add(new MultiBuy(offerCount, offerPrice));
		this.offerCode = null;
	}
	
	public Price(int basePrice, Integer offerCount, Character offerCode) {
		this.basePrice = basePrice;
		this.offerCode = offerCode;
	}
	
	public boolean useBasePrice() {
		return offerCount == null || offerPrice == null;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public Character getOfferCode() {
		return offerCode;
	}
	
}
