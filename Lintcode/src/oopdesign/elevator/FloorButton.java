package oopdesign.elevator;

public class FloorButton extends Button {

	private int level;
	Direction dir;

	public FloorButton(Direction dir) {
		super();
		this.dir = dir;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public void pressed() {
		if(isLightOn()) {
			return;
		}
		setLightOn(true);
		FloorRequest fq = new FloorRequest(this.level, dir);
		fq.send();
	}
	
}
