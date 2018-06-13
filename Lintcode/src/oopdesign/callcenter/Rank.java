package oopdesign.callcenter;

public enum Rank {
	Respondent(0), Manager(1), Director(2);
	
	private int level;
	
	private Rank(int level) {
		this.level = level;
	}
	
	public int getValue() {
		return this.level;
	}
	
	public static Rank getRankByValue(int level) throws Exception {
		if(level == 0) return Rank.Respondent; 
		else if(level == 1) return Rank.Manager; 
		else if(level == 2) return Rank.Director;
		else throw new Exception();
	}
}
