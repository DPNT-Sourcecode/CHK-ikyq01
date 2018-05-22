package befaster.solutions.CHK.offer;

import java.util.HashSet;
import java.util.Set;

import befaster.solutions.CHK.ShoppingCart;
import befaster.solutions.CHK.product.Product;

public class GroupDiscountOffer implements Offer {

	protected static final GroupDiscountOffer SINGLETON = new GroupDiscountOffer();

	private Set<Character> codes = new HashSet<Character>();
	private int offerCount;
	private int offerPrice;
	
	private GroupDiscountOffer() {};
	
	public GroupDiscountOffer(Set<Character> codes, int offerCount, int offerPrice) {
		this.codes.addAll(codes);
		this.offerCount = offerCount;
		this.offerPrice = offerPrice;
	}
	
	public void applyOffers(ShoppingCart cart) {
		
        // Apply group discount offers
        // Requirement: "The policy of the supermarket is to always favor the customer when applying special offers."
        // NOTE: To fulfil this requirement, it is necessary to apply a GDO to the most expensive items first
        //       For simplicity, the current implementation only considers the base price of each item
		// TODO Handling of overlapping group discounts
		// TODO Nesting in for loop
        Set<GroupDiscountOffer> gdos = getGroupDiscountOffers(cart);
        for (GroupDiscountOffer offer : gdos) {
			// Count number of items in offer
        	int itemsInOffer = 0;
        	for (Character code : offer.getCodes()) {
            	Integer count = cart.getCount(code);
            	if (count != null) {
            		itemsInOffer += count;
            	}
        	}
        	
        	// Apply offer, starting with most expensive items
        	while (itemsInOffer >= offer.getOfferCount()) {
        		for (int i = 0; i < offer.getOfferCount(); i++) {
                	for (Product product : cart.getProducts()) {
                		if (offer.getCodes().contains(product.getCode())) {
	                    	int count = cart.getCount(product);
	                    	if (count != 0) {
                    			--count;
                    			cart.getProductCounts().put(product.getCode(), count);
	                    		break;
	                    	}
                		}
                	}
				}
        		cart.addToTotal(offer.getOfferPrice());
        		itemsInOffer -= offer.getOfferCount();
        	}
		}
	}

	private Set<GroupDiscountOffer> getGroupDiscountOffers(ShoppingCart cart) {
		
        Set<GroupDiscountOffer> offers = new HashSet<GroupDiscountOffer>();
		for (Product product : cart.getProducts()) {
			if (product.getGroupDiscountOffer() != null) {
				offers.add(product.getGroupDiscountOffer());
			}
		}
        return offers;
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
	
	public Set<Character> getCodes() {
		return codes;
	}

	public Integer getOfferCount() {
		return offerCount;
	}

	public Integer getOfferPrice() {
		return offerPrice;
	}

}
