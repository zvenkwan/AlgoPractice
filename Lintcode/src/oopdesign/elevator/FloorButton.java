package oopdesign.elevator;

public class FloorButton extends Button {

	private int level;
	Direction dir;

	public FloorButton(int level, Direction dir) {
		super();
		this.dir = dir;
		this.level = level;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void pressed() {
		if(isLightOn()) {
			return;
		}
		setLightOn(true);
		System.out.println(this.level);
		FloorRequest fq = new FloorRequest(this.level, dir);
		fq.send();
	}
	
}
