package befaster.solutions.CHK.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO? Discuss use of static constructor and singleton pattern
 */
public class OfferServiceImpl implements OfferService {

	private static final List<Offer> offers = new ArrayList<>();
	static {
		offers.add(FreeProductsOffer.SINGLETON); // NOTE: This offer needs to be applied first
		offers.add(BulkBuyOffer.SINGLETON);
		offers.add(GroupDiscountOffer.SINGLETON);
	}
	
	@Override
	public List<Offer> getOffers() {
		return offers;
	}

}
