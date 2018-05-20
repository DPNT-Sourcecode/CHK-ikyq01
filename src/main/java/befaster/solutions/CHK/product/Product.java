package befaster.solutions.CHK.product;

import java.util.ArrayList;
import java.util.List;

import befaster.solutions.CHK.BulkBuyOffer;
import befaster.solutions.CHK.GetItemsFreeOffer;
import befaster.solutions.CHK.GroupDiscountOffer;

/**
 * A product, containing a code, base price, and any applicable offers.
 */
public class Product implements Comparable<Product> {
	
	private char code;
	private final int basePrice;
	
	private final List<BulkBuyOffer> bulkBuyOffers = new ArrayList<BulkBuyOffer>();
	private final List<GetItemsFreeOffer> getItemsFreeOffers = new ArrayList<GetItemsFreeOffer>();
	private final GroupDiscountOffer groupDiscountOffer;
	
	public Product(int basePrice) {
		this.basePrice = basePrice;
		this.groupDiscountOffer = null;
	}
	
	public Product(int basePrice, int offerCount, int offerPrice) {
		this.basePrice = basePrice;
		this.bulkBuyOffers.add(new BulkBuyOffer(offerCount, offerPrice));
		this.groupDiscountOffer = null;
	}
	
	public Product(int basePrice, int offerCount, char offerCode) {
		this.basePrice = basePrice;
		this.getItemsFreeOffers.add(new GetItemsFreeOffer(offerCount, offerCode));
		this.groupDiscountOffer = null;
	}
	
	public Product(int basePrice, List<BulkBuyOffer> bulkBuyOffers) {
		this.basePrice = basePrice;
		this.bulkBuyOffers.addAll(bulkBuyOffers);
		this.groupDiscountOffer = null;
	}
	
	public Product(int basePrice, GroupDiscountOffer groupDiscountOffer) {
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
	public int compareTo(Product o) {
		return o.basePrice - this.basePrice;
	}
	
}
