package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prices {

	private static final Map<Character, Price> prices = new HashMap<Character, Price>();
	static {
		List<BulkBuyOffer> bulkBuyOffers = new ArrayList<BulkBuyOffer>();
		bulkBuyOffers.add(new BulkBuyOffer(3, 130));
		bulkBuyOffers.add(new BulkBuyOffer(5, 200));
		prices.put('A', new Price(50, bulkBuyOffers));
		
		prices.put('B', new Price(30, 2, 45));
		prices.put('C', new Price(20));
		prices.put('D', new Price(15));
		prices.put('E', new Price(40, 2, 'B'));

		// Implement initially using a BulkBuyOffer
//		Our marketing team wants to try rewording the offer to see if it affects consumption
//		Instead of multi-pricing this item they want to say "buy 2Fs and get another F free"
//		The offer requires you to have 3 Fs in the basket.
		// TODO Is there any practical difference? 
		prices.put('F', new Price(10, 3, 20));
	}
	
	public static Map<Character, Price> getPrices() {
		return prices;
	}

}
