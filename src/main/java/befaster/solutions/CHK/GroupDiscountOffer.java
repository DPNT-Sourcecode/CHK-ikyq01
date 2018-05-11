package befaster.solutions.CHK;

import java.util.HashSet;
import java.util.Set;

public class GroupDiscountOffer {

	private final Set<Character> codes = new HashSet<Character>();
	private final int offerCount;
	private final int offerPrice;
	
	public GroupDiscountOffer(Set<Character> codes, int offerCount, int offerPrice) {
		this.codes.addAll(codes);
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
		if (object == null) return false;
		if (this == object) return true;
		if (object instanceof GroupDiscountOffer) {
			GroupDiscountOffer offer = (GroupDiscountOffer) object;
			// TODO null handling
			return offer.codes.equals(this.codes) && offer.offerCount == this.offerCount && offer.offerPrice == this.offerPrice;
		}
		return false;
	}

}
