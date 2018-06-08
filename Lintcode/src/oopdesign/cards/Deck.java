package oopdesign.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck<T extends Card> {

	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public boolean isEmpty() {
		return dealtIndex == cards.size();
	}
	
	public T dealCard() throws Exception {
		if(isEmpty()) throw new Exception();
		return cards.get(dealtIndex++);
	}
	
	
}
