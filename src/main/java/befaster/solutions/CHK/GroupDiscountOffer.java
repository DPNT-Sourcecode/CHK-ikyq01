package befaster.solutions.CHK;

import java.util.Set;

public class GroupDiscountOffer {

	private final Set<Character> codes;
	private final int offerPrice;
	
	public GroupDiscountOffer(Set<Character> codes, int offerPrice) {
		this.codes = codes;
		this.offerPrice = offerPrice;
	}
	
	public Set<Character> getCodes() {
		return codes;
	}

	public Integer getOfferPrice() {
		return offerPrice;
	}
	
	public boolean equals(Object object) {
		if (object instanceof GroupDiscountOffer) {
			GroupDiscountOffer offer = (GroupDiscountOffer) object;
			// TODO null handling
			return offer.codes.equals(this.codes) && offer.offerPrice == this.offerPrice;
		}
		return false;
	}

}
