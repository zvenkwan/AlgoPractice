package producerconsumer;

public class PrintNumberDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new PrintNumber(0, 10, "T1", 0));
		Thread t2 = new Thread(new PrintNumber(1, 10, "T2", 1000));
		t1.start();
		t2.start();
	}

}
