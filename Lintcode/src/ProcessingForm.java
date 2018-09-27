import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jguan
 *
1618. Processing Form
Given a csv file a, using vector to represent, each string contains m words, indicating a certain line of the csv file. Now it is required to right-align the words in each column of the file and output the new csv file (return vector)

Example
a = ["ac,abc,a","a,bb,ccc"]
return ["ac,abc,  a"," a, bb,ccc"]
Explanation:
the pre-processing file:
ac,abc,a
a,bb,ccc

the processed file:
ac,abc,  a
 a, bb,ccc
 */
public class ProcessingForm {
    /**
     * @param a: the csv file a
     * @return: return the processed file
     */
    public List<String> processingFile(List<String> a) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if(a == null || a.isEmpty()) return result;
        
        int column = a.get(0).split(",").length;
        
        int[] len = new int[column];
        for(String s: a) {
            String[] words = s.split(",");
            for(int i = 0 ; i < column; i ++) {
                len[i] = Math.max(len[i], words[i].length());
            }
        }
        
        for(String s: a) {
            
            String[] words = s.split(",");
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < column; i ++) {
                int diff = len[i] - words[i].length();
                for(int j = 0 ; j < diff; j++) {
                    sb.append(" ");
                }
                sb.append(words[i]).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        
        return result;
        
    }
}
