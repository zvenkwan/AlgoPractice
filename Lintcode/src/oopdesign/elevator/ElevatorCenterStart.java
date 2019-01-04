package oopdesign.elevator;

import java.util.HashMap;

public class ElevatorCenterStart {

	public static void main(String[] args) {
		RequestProcessCenter rpc = RequestProcessCenter.getInstance();
		Thread t1 = new Thread(rpc);
		t1.start();
		
		
		
		
		HashMap<Integer, Floor> fmap = new HashMap<>();
		Floor f1 = new Floor(1, Direction.up);
		Floor f2 = new Floor(2);
		Floor f3 = new Floor(3);
		Floor f4 = new Floor(4);
		Floor f5 = new Floor(5);
		Floor f6 = new Floor(6);
		Floor f7 = new Floor(7);
		Floor f8 = new Floor(8);
		Floor f9 = new Floor(9, Direction.down);
		fmap.put(1, f1);
		fmap.put(2, f2);
		fmap.put(3, f3);
		fmap.put(4, f4);
		fmap.put(5, f5);
		fmap.put(6, f6);
		fmap.put(7, f7);
		fmap.put(8, f8);
		fmap.put(9, f9);
		User u1 = new User("user A", fmap.get(1), Direction.up);
		User u2 = new User("user B", fmap.get(4), Direction.up);
		User u3 = new User("user C", fmap.get(9), Direction.down);
		User u4 = new User("user D", fmap.get(3), Direction.down);
		
		Thread tu1 = new Thread(u1);
		Thread tu2 = new Thread(u2);
		Thread tu3 = new Thread(u3);
		Thread tu4 = new Thread(u4);
		
		tu1.start();
		tu2.start();
		tu3.start();
		tu4.start();
	}
}
