package befaster.solutions.CHK.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import befaster.solutions.CHK.offer.BulkBuyOffer;
import befaster.solutions.CHK.offer.GroupDiscountOffer;

/**
 * Static implementation used for the coding challenge.
 */
public class ProductDaoImpl implements ProductDao {

	private static final Map<Character, Product> products = new HashMap<>();
	static {
		List<BulkBuyOffer> bulkBuyOffers = new ArrayList<>();
		bulkBuyOffers.add(new BulkBuyOffer(3, 130));
		bulkBuyOffers.add(new BulkBuyOffer(5, 200));
		add('A', new Product(50, bulkBuyOffers));
		
		add('B', new Product(30, 2, 45));
		add('C', new Product(20));
		add('D', new Product(15));
		add('E', new Product(40, 2, 'B'));

		// Implement initially using a BulkBuyOffer
//		Our marketing team wants to try rewording the offer to see if it affects consumption
//		Instead of multi-pricing this item they want to say "buy 2Fs and get another F free"
//		The offer requires you to have 3 Fs in the basket.
		// TODO Is there any practical difference? 
		add('F', new Product(10, 3, 20));
		
		add('G', new Product(20));

		bulkBuyOffers.clear();
		bulkBuyOffers.add(new BulkBuyOffer(5, 45));
		bulkBuyOffers.add(new BulkBuyOffer(10, 80));
		add('H', new Product(10, bulkBuyOffers));

		add('I', new Product(35));
		add('J', new Product(60));
		add('K', new Product(70, 2, 120));
		add('L', new Product(90));
		add('M', new Product(15));
		add('N', new Product(40, 3, 'M'));
		add('O', new Product(10));
		add('P', new Product(50, 5, 200));
		add('Q', new Product(30, 3, 80));
		add('R', new Product(50, 3, 'Q'));
		
		Set<Character> codes = new HashSet<Character>();
		codes.add('S');
		codes.add('T');
		codes.add('X');
		codes.add('Y');
		codes.add('Z');
		GroupDiscountOffer gdo = new GroupDiscountOffer(codes, 3, 45);
		
		add('S', new Product(20, gdo));
		add('T', new Product(20, gdo));
		add('U', new Product(40, 4, 120)); // TODO Syntactic sugar to help readability
		
		bulkBuyOffers.clear();
		bulkBuyOffers.add(new BulkBuyOffer(2, 90));
		bulkBuyOffers.add(new BulkBuyOffer(3, 130));
		add('V', new Product(50, bulkBuyOffers));

		add('W', new Product(20));
		
		add('X', new Product(17, gdo));
		add('Y', new Product(20, gdo));
		add('Z', new Product(21, gdo));
	}
	
	private static void add(char code, Product product) {
		product.setCode(code);
		products.put(code, product);
	}
	
	@Override
	public Product getProduct(char code) {
		return products.get(code);
	}


//	Our price table and offers: 
//		+------+-------+---------------------------------+
//		| Item | Price | Special offers                  |
//		+------+-------+---------------------------------+
//		| A    | 50    | 3A for 130, 5A for 200          |
//		| B    | 30    | 2B for 45                       |
//		| C    | 20    |                                 |
//		| D    | 15    |                                 |
//		| E    | 40    | 2E get one B free               |
//		| F    | 10    | 2F get one F free               |
//		| G    | 20    |                                 |
//		| H    | 10    | 5H for 45, 10H for 80           |
//		| I    | 35    |                                 |
//		| J    | 60    |                                 |
//		| K    | 70    | 2K for 120                      |
//		| L    | 90    |                                 |
//		| M    | 15    |                                 |
//		| N    | 40    | 3N get one M free               |
//		| O    | 10    |                                 |
//		| P    | 50    | 5P for 200                      |
//		| Q    | 30    | 3Q for 80                       |
//		| R    | 50    | 3R get one Q free               |
//		| S    | 20    | buy any 3 of (S,T,X,Y,Z) for 45 |
//		| T    | 20    | buy any 3 of (S,T,X,Y,Z) for 45 |
//		| U    | 40    | 3U get one U free               |
//		| V    | 50    | 2V for 90, 3V for 130           |
//		| W    | 20    |                                 |
//		| X    | 17    | buy any 3 of (S,T,X,Y,Z) for 45 |
//		| Y    | 20    | buy any 3 of (S,T,X,Y,Z) for 45 |
//		| Z    | 21    | buy any 3 of (S,T,X,Y,Z) for 45 |
//		+------+-------+---------------------------------+

}
