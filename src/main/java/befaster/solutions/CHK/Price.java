package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Comments!
 * 
 * @author Name
 */
public class Price implements Comparable<Price> {
	
	private char code;
	private final int basePrice;
	
	private final List<BulkBuyOffer> bulkBuyOffers = new ArrayList<BulkBuyOffer>();
	private final List<GetItemsFreeOffer> getItemsFreeOffers = new ArrayList<GetItemsFreeOffer>();
	private final GroupDiscountOffer groupDiscountOffer;
	
	public Price(int basePrice) {
		this.basePrice = basePrice;
		groupDiscountOffer = null;
	}
	
	public Price(int basePrice, int offerCount, int offerPrice) {
		this.basePrice = basePrice;
		bulkBuyOffers.add(new BulkBuyOffer(offerCount, offerPrice));
		groupDiscountOffer = null;
	}
	
	public Price(int basePrice, int offerCount, char offerCode) {
		this.basePrice = basePrice;
		getItemsFreeOffers.add(new GetItemsFreeOffer(offerCount, offerCode));
		groupDiscountOffer = null;
	}
	
	public Price(int basePrice, List<BulkBuyOffer> bulkBuyOffers) {
		this.basePrice = basePrice;
		this.bulkBuyOffers.addAll(bulkBuyOffers);
		groupDiscountOffer = null;
	}
	
	public Price(int basePrice, GroupDiscountOffer groupDiscountOffer) {
		this.basePrice = basePrice;
		groupDiscountOffer = groupDiscountOffer;
	}
	
	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
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
