package oopdesign.cards;

import java.util.ArrayList;

public class Hand<T extends Card> {
	private ArrayList<T> cards;
	public Hand() {
		cards = new ArrayList<T>();
	}
	
	public void addCard(T card) {
		cards.add(card);
	}
	
	public int score() {
		int score = 0;
		for(T card: cards) {
			score += card.getValue();
		}
		return score;
	}
}
