package OA;

public class ReorderLogFiles_1 {
	public String[] reorderLogFiles(String[] logs) {
		int alphaFileLocation = 0;
		
		for(int i = 0; i < logs.length; i ++)
		{
			if(!isDigitFile(logs[i]))
			{
				swap(logs, alphaFileLocation, i);
				alphaFileLocation++;
			}
		}
		return logs;
	}
	
	private void swap(String[] logs, int index1, int index2)
	{
		if(index1 == index2)
		{
			return;
		}
		String temp = logs[index1];
		logs[index1] = logs[index2];
		logs[index2] = temp;
	}
	
	private boolean isDigitFile(String log)
	{
		return Character.isDigit(log.split(" ")[1].charAt(0));
	}
	
	
	public static void main(String[] args)
	{
		String[] logs = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		ReorderLogFiles_1 solution = new ReorderLogFiles_1();
		logs = solution.reorderLogFiles(logs);
		for(String log : logs)
		{
			System.out.print(log + " ");
		}
		
	}
}
