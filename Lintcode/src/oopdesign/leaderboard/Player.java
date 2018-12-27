package oopdesign.leaderboard;

public class Player {

	int id;
	int score;
	int count;
	double average;
	public Player(int id, int score) {
		this.id = id;
		addScore(score);
	}
//	@Override
//	public int compareTo(Player o) {
//		Player p = (Player)o;
//		return p.score - this.score;
//	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	
	public Player addScore(int score) {
		this.count++;
		this.score += score;
		this.average = (double) this.score/ (double) this.count;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString() {
		return this.id + ", " + this.average;
	}
	
	
}
