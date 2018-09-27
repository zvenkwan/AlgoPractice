import java.util.List;

/**
 * 
 * @author jguan
 *
1614. Highest growth stock
Give a list of stock IDs, initial prices and last prices, find the stock with the highest growth rate, return the ID(If the rate is the same, return the first one)

Example
Given : stock = [["a01","13.22","15.33"],["a02","13.22","14.22"]]
Return : "a01"
 */
public class Highestgrowthstock {
    /**
     * @param Stock: Stock information
     * @return: return id
     */
    public String highestGrowth(List<List<String>> Stock) {
        // Write your code here
        if(Stock == null || Stock.size() == 0) return null;
        double max = 0;
        String id = "";
        for(List<String> st: Stock) {
            double rate = Double.parseDouble(st.get(2)) / Double.parseDouble(st.get(1));
            if(rate > max) {
                max = rate;
                id = st.get(0);
            }
        }
        return id;
    }
}
