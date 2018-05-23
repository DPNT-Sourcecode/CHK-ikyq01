package befaster.solutions.CHK.product;

import java.util.ArrayList;
import java.util.List;

import befaster.solutions.CHK.offer.BulkBuyOffer;
import befaster.solutions.CHK.offer.GetProductsFreeOffer;
import befaster.solutions.CHK.offer.GroupDiscountOffer;

/**
 * A product, containing a code, base price, and any applicable offers.
 */
public class Product implements Comparable<Product> {
	
	private char code;
	private final int basePrice;
	
	// TODO? A more generic solution is possible, but would the extra complexity be justified?
	//       (e.g one might use a map from offer codes to a list of offers)
	private final List<GetProductsFreeOffer> getProductsFreeOffers = new ArrayList<>();
	private final List<BulkBuyOffer> bulkBuyOffers = new ArrayList<>();
	private final GroupDiscountOffer groupDiscountOffer;
	
	public Product(
			int basePrice,
			List<GetProductsFreeOffer> getProductsFreeOffers,
			List<BulkBuyOffer> bulkBuyOffers,
			GroupDiscountOffer groupDiscountOffer) {
		
		this.basePrice = basePrice;
		if (getProductsFreeOffers != null) {
			this.getProductsFreeOffers.addAll(getProductsFreeOffers);
		}
		if (bulkBuyOffers != null) {
			this.bulkBuyOffers.addAll(bulkBuyOffers);
		}
		this.groupDiscountOffer = groupDiscountOffer;
	}
	
	// Convenience constructors for coding challenge implementation of ProductDaoImpl
	protected Product(int basePrice) {
		this(basePrice, null, null, null);
	}
	protected Product(int basePrice, int offerCount, int offerPrice) {
		this(basePrice, null, null, null);
		this.bulkBuyOffers.add(new BulkBuyOffer(offerCount, offerPrice));
	}
	protected Product(int basePrice, int numberOfChargedProducts, char freeProductCode) {
		this(basePrice, null, null, null);
		this.getProductsFreeOffers.add(new GetProductsFreeOffer(numberOfChargedProducts, 1, freeProductCode));
	}
	protected Product(int basePrice, List<BulkBuyOffer> bulkBuyOffers) {
		this(basePrice, null, bulkBuyOffers, null);
	}
	protected Product(int basePrice, GroupDiscountOffer groupDiscountOffer) {
		this(basePrice, null, null, groupDiscountOffer);
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

	public List<GetProductsFreeOffer> getGetProductsFreeOffers() {
		return getProductsFreeOffers;
	}

	public List<BulkBuyOffer> getBulkBuyOffers() {
		return bulkBuyOffers;
	}

	public GroupDiscountOffer getGroupDiscountOffer() {
		return groupDiscountOffer;
	}

	@Override
	public int compareTo(Product o) {
		return o.basePrice - this.basePrice;
	}
	
}
