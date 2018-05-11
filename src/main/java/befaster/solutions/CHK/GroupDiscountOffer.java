package befaster.solutions.CHK;

import java.util.Set;

public class GroupDiscountOffer {

	private final Set<Character> codes;
	private final int offerCount;
	private final int offerPrice;
	
	public GroupDiscountOffer(Set<Character> codes, int offerCount, int offerPrice) {
		this.codes = codes;
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
	}
	
	public Set<Character> getCodes() {
		return codes;
	}

	public Integer getOfferCount() {
		return offerCount;
	}

	public Integer getOfferPrice() {
		return offerPrice;
	}
	
	public boolean equals(Object object) {
		if (object instanceof GroupDiscountOffer) {
			GroupDiscountOffer offer = (GroupDiscountOffer) object;
			// TODO null handling
			return offer.codes.equals(this.codes) && offer.offerCount == this.offerCount && offer.offerPrice == this.offerPrice;
		}
		return false;
	}

}
