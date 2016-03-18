package ArrayAndString;
/**
 * 168. Excel Sheet Column Title
 * @author zg55
 *Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String dict[]= {"A", "B", "C", "D", "E", "F", "G",
        				"H", "I", "J", "K", "L", "M", "N",
        				"O", "P", "Q", "R", "S", "T",
        				"U", "V", "W", "X", "Y", "Z"};
        String title = "";
        for(int x=n; x>0;x=(x-1)/26) {
        	title=dict[(x-1)%26]+title;
        }
        return title;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2000;
		System.out.println(new ExcelSheetColumnTitle().convertToTitle(n));
	}

}
