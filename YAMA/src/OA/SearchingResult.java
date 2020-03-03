package OA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.ListUI;

import TrieRelated.Trie;
import Utils.ListUtils;

public class SearchingResult {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans= new ArrayList<List<String>>();
        int N=searchWord.length();
        if (N==0) return ans;
        
        Arrays.sort(products);
        List<String> pool=Arrays.asList(products);
        for (int i=1;i<=N;i++) {
            String str=searchWord.substring(0,i);
            List<String> words=new ArrayList<String>();
            pool.forEach(word->{if (word.startsWith(str)) words.add(word);});
            int e = (words.size()<3) ? words.size():3;
            ans.add(words.subList(0,e));
            pool=words;
        }
        return ans;
    }
	
	public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
		List<List<String>> result = new ArrayList<>();
		
		if(products == null || products.length == 0)
		{
			return result;
		}
		List<String> childResult = new ArrayList<String>();
		Arrays.sort(products);
		for(int i = 0; i < searchWord.length(); i ++)
		{
			childResult = new ArrayList<String>();
			for(int index = 0; index < products.length; index ++)
			{
				if(products[index].startsWith(searchWord.substring(0, i + 1)))
				{
					childResult.add(products[index]);
				}
				if(childResult.size() == 3)
				{
					result.add(childResult);
					break;
				}
			}
		}
		
		if(childResult.size() > 0)
		{
			result.add(childResult);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		SearchingResult solution = new SearchingResult();
		String[] words = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		
//		for(List<String> list : solution.suggestedProducts(words, "mou"))
//		{
//			ListUtils.printList_StringElement(list);
//			System.out.println();
//		}
		
		for(List<String> list : solution.suggestedProducts1(words, "mou"))
		{
			ListUtils.printList_StringElement(list);
			System.out.println();
		}
	}
}
