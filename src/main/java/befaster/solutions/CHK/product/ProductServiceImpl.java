package befaster.solutions.CHK.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public Map<Character, Integer> countProducts(String productCodes) {
		return countCharacters(productCodes);
	}
	
	/**
	 * Counts the number of times each character occurs in the given string.
	 */
	private Map<Character, Integer> countCharacters(String string) {
	
        Map<Character, Integer> counts = new HashMap<>();
    	char[] codes = string.toCharArray();
        for (char code : codes) {
			Integer count = counts.get(code);
			if (count == null) {
				count = 1;
			} else {
				++count;
			}
			counts.put(code, count);
		}
        return counts;
	}
	
	@Override
	public Product getProduct(char code) throws UnknownProductException {
		Product product = productDao.getProduct(code);
		// TODO? Should the null check be in the service, or the DAO?
		if (product == null) {
			throw new UnknownProductException("Unknown code: " + code);
		}
		return product;
	}
	
	@Override
	public List<Product> getProducts(Set<Character> productCodes) throws UnknownProductException {
		
        List<Product> products = new ArrayList<Product>();
        for (Character code : productCodes) {
			Product product = getProduct(code);
			// TODO Move
			Collections.sort(product.getBulkBuyOffers());
			products.add(product);
        }
		Collections.sort(products);
		return products;
	}
	
}
