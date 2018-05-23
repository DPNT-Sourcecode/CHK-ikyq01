package befaster.solutions.CHK.offer;

import java.util.List;

public interface OfferService {
	
	/**
	 * Gets the Offer singletons, in the order in which they must be applied.
	 */
	List<Offer> getOffers();

}
