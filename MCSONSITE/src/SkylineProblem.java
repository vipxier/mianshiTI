import java.util.ArrayList;
import java.util.Arrays;

public class SkylineProblem {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result  = new ArrayList<>();
		
		if(buildings == null || buildings.length == 0 || buildings[0].length == 0)
		{
			return result;
		}
		
		int buildingCount = buildings.length;
		
		if(buildingCount == 1)
		{
			result.add(new ArrayList<Integer>() {
				{
				add(buildings[0][0]);
				add(buildings[0][2]);
				}
			});
			
			result.add(new ArrayList<Integer>() {
				{
					{
					add(buildings[0][1]);
					add(0);
					}
					
				}
			});
			
			List<List<Integer>> leftResult = getSkyline(Arrays.copyOfRange(buildings, 0, buildingCount / 2));
			List<List<Integer>> rightResult = getSkyline(Arrays.copyOfRange(buildings, buildingCount / 2, buildingCount))
			return merge(leftResult, rightResult);
		}
	}
		
		private List<List<Integer>> merge(List<List<Integer>> leftResult, List<List<Integer>> rightResult)
		{
			int leftIndex = 0;
			int rightIndex  =0;
			int leftSize = leftResult.size();
			int rightSize = rightResult.size();
			
			int currentXValue = 0;
			int prevYValue = 0;
			int maxYValue = 0;
			int leftYValue = 0;
			int rightYValue = 0;
			
			List<List<Integer>> result = new ArrayList<List<Integer>>();)
			
			while(leftIndex < leftSize && rightIndex < rightSize)
			{
				List<Integer> leftCoordinate = leftResult.get(leftIndex);
				List<Integer> rightCoordinate = rightResult.et(rightIndex)
				if(leftCoordinate.get(0) < rightCoordinate.get(0))
				{
					currentXValue = leftCoordinate.get(0);
					leftYValue = leftCoordinate.get(1);
					leftIndex++;
				}
				else
				{
					currentXValue = rightCoordinate.get(0);
					rightYValue = rightCoordinate.get(1);
					rightIndex ++;
				}
				
				maxYValue = Math.max(leftYValue, rightYValue);
				
				if(maxYValue != prevYValue)
				{
					updateOutput(result, currentXValue, maxYValue);
				}
			}
			
			while(leftIndex < leftSize)
			{
				List<Integer> coordinate = leftResult.get(leftIndex);
				
				if(coordinate.get(1) != prevYvalue)
				{
					updateOutput(result, coordinate.get(0), coordinate.get(1));
					prevYValue = coordinate.get(1);
				}
				
				leftIndex ++;
			}
			
			while(rightIndex < rightSize)
			{
				List<Integer> coordinate = rightResult.get(rightIndex);
				if(coordinate.get(1) != prevYValue)
				{
					updateResult(result, coordinate.get(0), coordinate.get(1));
					prevYValue = coordinate.get(1);
				}
				
				rightIndex ++;
			}
			
			return result;
		}
		
		private void updateOutput(List<List<Integer>> result, int xValue, int yValue)
		{
			if(result.isEmpty() || result.get(result.size() - 1).get(0) != xValue)
			{
				result.add(xValue);
				result.add(yValue);
			}
			else
			{
				result.get(result.size() - 1).set(1, y);
			}
		}
	}
}
