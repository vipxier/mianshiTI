package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> result = new ArrayList<>();
		if(products == null || products.length == 0)
		{
			return result;
		}
		
		Arrays.sort(products);
		ArrayList<String> productList = new ArrayList(Arrays.asList(products));
		
		for(int i = 0; i< searchWord.length(); i ++)
		{
			List<String> searchResult = new ArrayList<String>();
			for(String product : productList)
			{
				if(product.startsWith(searchWord.substring(0, i + 1)))
				{
					searchResult.add(product);
					if(searchResult.size() == 3)
					{
						break;
					}
				}
			}
			result.add(searchResult);
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		String[] products = {"bags","baggage","banner","box","cloths"}; 
		String searchWord = "bags";
		SearchSuggestion solution = new SearchSuggestion();
		for(List<String> list : solution.suggestedProducts(products, searchWord))
		{
			System.out.println(list);
		}
	}
}
