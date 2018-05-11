package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Comments!
 * 
 * @author Name
 */
public class Price implements Comparable<Price> {
	
	private final int basePrice;
	
	private final List<BulkBuyOffer> bulkBuyOffers = new ArrayList<BulkBuyOffer>();
	private final List<GetItemsFreeOffer> getItemsFreeOffers = new ArrayList<GetItemsFreeOffer>();
	
	public Price(int basePrice) {
		this.basePrice = basePrice;
	}
	
	public Price(int basePrice, int offerCount, int offerPrice) {
		this.basePrice = basePrice;
		bulkBuyOffers.add(new BulkBuyOffer(offerCount, offerPrice));
	}
	
	public Price(int basePrice, int offerCount, char offerCode) {
		this.basePrice = basePrice;
		getItemsFreeOffers.add(new GetItemsFreeOffer(offerCount, offerCode));
	}
	
	public Price(int basePrice, List<BulkBuyOffer> bulkBuyOffers) {
		this.basePrice = basePrice;
		this.bulkBuyOffers.addAll(bulkBuyOffers);
	}
	
	public boolean useBasePrice() {
//		return offerCount == null || offerPrice == null;
		return false; // TODO
	}

	public int getBasePrice() {
		return basePrice;
	}

	public List<BulkBuyOffer> getBulkBuyOffers() {
		return bulkBuyOffers;
	}

	public List<GetItemsFreeOffer> getGetItemsFreeOffers() {
		return getItemsFreeOffers;
	}

	@Override
	public int compareTo(Price o) {
		return o.basePrice - this.basePrice;
	}
	
}
