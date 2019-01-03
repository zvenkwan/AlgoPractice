package oopdesign.elevator;

public class Floor {
	private int level;
	private FloorButton[] btns;
	
	public Floor(int level) {
		this.level = level;
		btns = new FloorButton[2];
		btns[0] = new FloorButton(Direction.up);
		btns[1] = new FloorButton(Direction.down);
	}
	
	public Floor(int level, Direction dir) {
		this.level = level;
		btns = new FloorButton[1];
		btns[0] = new FloorButton(dir);
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public FloorButton[] getBtns() {
		return btns;
	}
	public void setBtns(FloorButton[] btns) {
		this.btns = btns;
	}
}
