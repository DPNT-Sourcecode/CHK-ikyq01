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
	private final List<GetOneFreeOffer> getItemsFreeOffers = new ArrayList<GetOneFreeOffer>();
	
	public Price(int basePrice) {
		this.basePrice = basePrice;
	}
	
	public Price(int basePrice, int offerCount, int offerPrice) {
		this.basePrice = basePrice;
		multiBuys.add(new MultiBuy(offerCount, offerPrice));
	}
	
	public Price(int basePrice, int offerCount, char offerCode) {
		this.basePrice = basePrice;
		getItemsFreeOffers.add(new GetOneFreeOffer(offerCount, offerCode));
	}
	
	public boolean useBasePrice() {
//		return offerCount == null || offerPrice == null;
		return false; // TODO
	}

	public int getBasePrice() {
		return basePrice;
	}

	public List<MultiBuy> getMultiBuys() {
		return multiBuys;
	}

	public List<GetOneFreeOffer> getGetItemsFreeOffers() {
		return getItemsFreeOffers;
	}
	
}
