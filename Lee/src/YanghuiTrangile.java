import java.util.ArrayList;
import java.util.List;

public class YanghuiTrangile
{
public static  List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       
       if(numRows == 0)
       {
           return result;
       }
       
       List<Integer> list = new ArrayList<Integer>();
       list.add(1);
       result.add(new ArrayList<Integer>(list));
       
      for(int i = 1; i < numRows;i ++)
      {
          list.clear();
          List<Integer> prevList = result.get(i - 1);
          for(int j = 0; j <= i; j ++)
          {
              if(j == 0)
              {
                  list.add(1);
              }
              else if(j == i)
              {
                  list.add(1);
              }
              else
              {
                  list.add(prevList.get(j - 1) + prevList.get(j));
              }
          }
          result.add(new ArrayList<Integer>(list));
      }
       
       return result;
    }

    public static void main(String[] args)
    {
        System.out.println(generate(10));
    }
}
