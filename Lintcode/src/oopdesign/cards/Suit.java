package oopdesign.cards;

public enum Suit {

	Diamond(0), Club(2), Heart(3), Spade(4);
	private int value;
	private Suit(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public static Suit getSuitByValue(int value) throws Exception {
		switch(value) {
		case 0:
			return Diamond;
		case 1:
			return Club;
		case 2:
			return Heart;
		case 3:
			return Spade;
			default:
				throw new Exception();
		}
	}
}
