package oopdesign.cards;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {

	public int score() {
		ArrayList<Integer> scores = possibleScore();
		int minOver = 32;
		int maxUnder = -1;
		for(int score : scores) {
			if(score <= 21) {
				maxUnder = Math.max(maxUnder, score);
			} else {
				minOver = Math.min(minOver, score);
			}
		}
		
		return maxUnder == -1? minOver: maxUnder;
	}

	private ArrayList<Integer> possibleScore() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int sum = 0;
		int countAce = 0;
		for(BlackJackCard card : cards) {
			if(card.isAce())
				countAce++;
			else sum += card.getValue();
		}
		for(int i = 1 ; i <= countAce; i ++) {
			int t = sum;
			scores.add(t + i * 1 + (countAce - i ) * 10);
		}
		return scores;
	}
	
	public void addCard(BlackJackCard card) throws Exception {
//		can not have more card
		if(isBusted()) throw new Exception(); 
		else
			cards.add(card);
	}
	
	public boolean isBusted() {
		return score() > 21;
	}
	
	public boolean is21() {
		return score() == 21;
	}
	
	public boolean isBlackJack() {
		return is21() && cards.size() == 2;
	}
}
