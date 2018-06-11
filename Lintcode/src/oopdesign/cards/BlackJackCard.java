package oopdesign.cards;

public class BlackJackCard extends Card{

	public BlackJackCard(int faceValue, Suit suit) {
		super(faceValue, suit);
	}
	@Override
	public int getValue() {

		if(isAce()) return 1;
		else if(isFaceCard()) return 10;
		return faceValue;
	}

	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
	
	public int minValue() {
		if(isAce()) return 1;
		else return faceValue;
	}
	
	public int maxValue() {
		if(isAce()) return 10;
		else return faceValue;
	}
	
	
}
