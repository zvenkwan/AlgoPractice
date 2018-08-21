package producerconsumer;

public class PrintNumber implements Runnable {

	private int start;
	private int max;
	private String name;
	private long delay;
	public PrintNumber(int start, int max, String name, long delay) {
		this.name = name;
		this.start = start;
		this.max = max;
		this.delay = delay;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(delay);
			while(start < max) {
				System.out.println("Thread " + name + ": " + start);
				start += 2;
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
