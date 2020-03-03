package EasyQuestions;

import java.util.ArrayList;
import java.util.List;

public class Anagram
{

    public static boolean isAnagram(String s, String t)
    {
        if (s == null || t == null || s.length() != t.length())
        {
            return false;
        }
        List<Character> list = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            list.add(s.charAt(i));
        }

        for (int j = 0; j < t.length(); j++)
        {
            if (list.contains(t.charAt(j)))
            {
                list.remove(list.indexOf(t.charAt(j)));
            }
        }

        return list.isEmpty();
    }

    public static boolean isAnagram_MergeSort(String s, String t)
    {
        if (s == null || t == null || s.length() != t.length())
        {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        mergeSort(sArray, 0, s.length() - 1);
        mergeSort(tArray, 0, t.length() - 1);
        for (int i = 0; i < s.length()-1; i++)
        {
            if (sArray[i] != tArray[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void mergeSort(char[] charArray, int start, int end)
    {
        if (start < end)
        {
            int mid = start + (end - start) / 2;
            mergeSort(charArray, start, mid);
            mergeSort(charArray, mid + 1, end);
            merge(charArray, start, mid, end);
        }
    }

    public static void merge(char[] charArray, int start, int mid, int end)
    {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        char[] leftArray = new char[n1];
        char[] rightArray = new char[n2];

        for (int lIndex = 0; lIndex < n1; lIndex++)
        {
            leftArray[lIndex] = charArray[start + lIndex];
        }

        for (int rIndex = 0; rIndex < n2; rIndex++)
        {
            rightArray[rIndex] = charArray[mid + 1 + rIndex];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2)
        {
            if (leftArray[i] <= rightArray[j])
            {
                charArray[k] = leftArray[i];
                i++;
            }
            else
            {
                charArray[k] = leftArray[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            charArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            charArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(isAnagram_MergeSort("anagram", "naagram"));
    }
}
