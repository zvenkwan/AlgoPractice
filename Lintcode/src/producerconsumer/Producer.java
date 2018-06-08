package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private final BlockingQueue<Integer> queue;
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			try {
                System.out.println("Produced: " + i);
				queue.put(i);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
