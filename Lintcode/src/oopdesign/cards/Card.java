package oopdesign.cards;

public abstract class Card {

	protected Suit suit;
//	1-13 or 1-10, J Q K if defined character
	protected int faceValue;
	protected boolean available = true;
	
	public Card(int faceValue, Suit suit) {
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
//	the actual value could be different in different games
	public abstract int getValue();
	
	public Suit getSuit() {
		return suit;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
}
