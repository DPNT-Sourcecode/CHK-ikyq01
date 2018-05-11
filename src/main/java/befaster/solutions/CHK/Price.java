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
		this.groupDiscountOffer = null;
	}
	
	public Price(int basePrice, int offerCount, int offerPrice) {
		this.basePrice = basePrice;
		this.bulkBuyOffers.add(new BulkBuyOffer(offerCount, offerPrice));
		this.groupDiscountOffer = null;
	}
	
	public Price(int basePrice, int offerCount, char offerCode) {
		this.basePrice = basePrice;
		this.getItemsFreeOffers.add(new GetItemsFreeOffer(offerCount, offerCode));
		this.groupDiscountOffer = null;
	}
	
	public Price(int basePrice, List<BulkBuyOffer> bulkBuyOffers) {
		this.basePrice = basePrice;
		this.bulkBuyOffers.addAll(bulkBuyOffers);
		this.groupDiscountOffer = null;
	}
	
	public Price(int basePrice, GroupDiscountOffer groupDiscountOffer) {
		this.basePrice = basePrice;
		this.groupDiscountOffer = groupDiscountOffer;
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

	public GroupDiscountOffer getGroupDiscountOffer() {
		return groupDiscountOffer;
	}

	@Override
	public int compareTo(Price o) {
		return o.basePrice - this.basePrice;
	}
	
}
