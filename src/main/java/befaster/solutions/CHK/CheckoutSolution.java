package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
	
	private static final Map<Character, Price> prices = new HashMap<Character, Price>(); 
	
    public Integer checkout(String skus) {
    	
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
    	char[] chars = skus.toCharArray();
        for (char c : chars) {
			Integer count = counts.get(c);
			if (count == null) {
				count = 1;
			} else {
				++count;
			}
			counts.put(c, count);
		}
        
        for (Character c : counts.keySet()) {
        	int count = counts.get(c); 
			
        	
		}
        
    	int total = 0;
        return total;
    }
}
