package interviews.wyfr;

import java.util.HashMap;
import java.util.Random;

/**
 * 
 * @author jguan
 *现在轮盘赌博，从1-36个数字里面随机选择一个，1-12标记为L，13-24标记为M，25-36标记为H，
 *现在策略是一个人带着100刀参与赌博，每次bet为10美金，当遇到4个一样的L的时候下注买M，4个一样M的时候下注买H，4个一样H的时候下注买L，买的时候赢10刀，输也10刀，
当100转或者钱为0的时候结束，问最后情况，需要打印东西验证算法。
 */
public class Roulette {

	private static int MAX = 36;
//	a list store history of result with occurrence
	private HashMap<Integer, Integer> results;
	
	public Roulette() {
		results = new HashMap<Integer, Integer>();
	}
	
	public int roll() {
		Random rand = new Random();
		int res = 1 + rand.nextInt(MAX);
		this.results.put(res, this.results.getOrDefault(res, 0) + 1);
		return res;
	}
	
	public int getOccurence(int val) {
		return this.results.getOrDefault(val, 0);
	}
	
	public String toLetter(int val) {
		if(val >= 1 && val <= 12) {
			return "L";
		} else if(val >= 13 && val <= 24) {
			return "M";
		} else if(val >= 25 && val <= 36) {
			return "H";
		} else {
		     throw new IllegalArgumentException("value must be between 1 and 36");
		}
	}
	
	public boolean hasWon(String bet, int res) {
		return toLetter(res).equals(bet);
	}
	
	public static void main(String[] args) {
		int total = 100;
		int gameCount = 0;
		Roulette rou = new Roulette();
		String lastBet = "NOBET";
		while(gameCount < 100) {
			if(total == 0) {
				System.out.println("You have no money");
				break;
			}
			gameCount++;
			int res = rou.roll();
			System.out.println("The result of " + gameCount + " game is " + res + " occurred " + rou.getOccurence(res) + " times.");
//			first:  check has won
			if(rou.hasWon(lastBet, res)) {
				total += 20;
				System.out.println("You win! Your total is " + total);
			} else if(lastBet.equals("NOBET")){
				System.out.println("You did not play");
			} else {
				System.out.println("You lose! Your total is " + total);
			}
//			second:  check if bet next game
			int occ = rou.getOccurence(res);
			if(occ >= 4) {
//				occurred 4 times, bet
				String let = rou.toLetter(res);
				if(let.equals("L")) {
					lastBet = "M";
				} else if(let.equals("M")) {
					lastBet = "H";
				} else {
					lastBet = "L";
				}
				total -= 10;
			} else {
				lastBet = "NOBET";
			}
		}
		
	}
}
