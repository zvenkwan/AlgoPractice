package oopdesign.leaderboard;

public class Driver {
	public static void main(String[] args) {
		Board b = Board.getInstance();
		System.out.println(b.max(2));
		b.addScore(1, 10);
		System.out.println(b.max(2));
		b.addScore(1, 20);
		System.out.println(b.max(2));
		b.addScore(2, 20);
		System.out.println(b.max(2));
		b.addScore(3, 30);
		System.out.println(b.max(2));
		b.reset(3);
		System.out.println(b.max(3));
	}
}
