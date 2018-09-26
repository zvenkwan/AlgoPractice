/**
 * 
 * @author jguan
 *Press A For Caps Lock
 *Input:
 *My keyboard is broken!
 *Output:
 *My keyboRD IS BROKEN!
 *
 *Input:
 *"Baa, Baa!" said the sheep
 *Output:
 *"B, B!" sID THE SHEEP
 *
 *
 */
public class PressAForCapsLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("My keyboard is broken!"));
		System.out.println(solution("\"Baa, Baa!\" said the sheep"));
	}

	public static String solution(String s) {
		if(s == null) return null;
		boolean isCapsOn = false;
		StringBuilder sb = new StringBuilder();
		for(char c: s.toCharArray()) {
			if(c == 'a') {
				isCapsOn = !isCapsOn;
			}
			else if(isCapsOn) {
				sb.append(Character.toUpperCase(c) );
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
		
	}
}
