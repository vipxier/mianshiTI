package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import utils.ListUtils;

import java.util.Set;

public class GetKthFrequentItems
{
    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (nums == null || k <= 0 || nums.length < k)
        {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int item : nums)
        {
            if (!map.containsKey(item))
            {
                map.put(item, 1);
            }
            else
            {
                int count = map.get(item);
                map.replace(item, ++count);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }
        });

        int index = 0;
        while (k > 0 && index <= list.size() - 1)
        {
            result.add(list.get(index++).getKey());
            k--;
        }

        return result;
    }
    
    public static void main(String[] args)
    {
        int[] array = {1,3,2,2,1,4,1,2,4,1,23,22,1,1,2,2,2,3,1,21,2};
        ListUtils.printList(topKFrequent(array, 3));
    }
}
