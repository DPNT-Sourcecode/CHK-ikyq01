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
	
	public static Price getPrice(char code) {
		return prices.get(code);
	}


//	Our price table and offers: 
//		+------+-------+------------------------+
//		| Item | Price | Special offers         |
//		+------+-------+------------------------+
//		| A    | 50    | 3A for 130, 5A for 200 |
//		| B    | 30    | 2B for 45              |
//		| C    | 20    |                        |
//		| D    | 15    |                        |
//		| E    | 40    | 2E get one B free      |
//		| F    | 10    | 2F get one F free      |
//		| G    | 20    |                        |
//		| H    | 10    | 5H for 45, 10H for 80  |
//		| I    | 35    |                        |
//		| J    | 60    |                        |
//		| K    | 80    | 2K for 150             |
//		| L    | 90    |                        |
//		| M    | 15    |                        |
//		| N    | 40    | 3N get one M free      |
//		| O    | 10    |                        |
//		| P    | 50    | 5P for 200             |
//		| Q    | 30    | 3Q for 80              |
//		| R    | 50    | 3R get one Q free      |
//		| S    | 30    |                        |
//		| T    | 20    |                        |
//		| U    | 40    | 3U get one U free      |
//		| V    | 50    | 2V for 90, 3V for 130  |
//		| W    | 20    |                        |
//		| X    | 90    |                        |
//		| Y    | 10    |                        |
//		| Z    | 50    |                        |
//		+------+-------+------------------------+
}
