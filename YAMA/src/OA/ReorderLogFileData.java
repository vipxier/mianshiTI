package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFileData {
	public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0)
        {
            return logs;
        }
        
        ArrayList<String> logFileList = new ArrayList<String>(Arrays.asList(logs));
        
        int alphaFileLocation = 0;
        
        for(int i = 0; i < logFileList.size(); i ++)
        {
            String logFile = logFileList.get(i);
            if(!isDigitLogFile(logFile))
            {
                logFileList.remove(logFile);
                logFileList.add(alphaFileLocation ++, logFile);
            }
        }
        
        if(alphaFileLocation == 0)
        {
            return logs;
        }
        
        Comparator<String> logFileComparator = new Comparator<String>()
        {
            @Override
            public int compare(String logFile1, String logFile2)
            {
                String[] logFile1_words = logFile1.split(" ");
                String[] logFile2_words = logFile2.split(" ");
                
                for(int i = 1; i < Math.min(logFile1_words.length, logFile2_words.length); i ++)
                {
                    if(!logFile1_words[i].contentEquals(logFile2_words[i]))
                    {
                        return logFile1_words[i].compareTo(logFile2_words[i]);
                    }
                }
                
                return logFile1_words[0].compareTo(logFile2_words[0]);
            }
        };
        String[] newLogs = logFileList.toArray(new String[0]);
        Arrays.sort(newLogs, 0, alphaFileLocation, logFileComparator);
        
        return newLogs;
    }
    
    private boolean isDigitLogFile(String logFile)
    {
        return Character.isDigit(logFile.split(" ")[1].charAt(0));
    }
}
