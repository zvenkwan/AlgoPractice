package producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Driver {
	public static void main(String args[]) {

		// Creating shared object
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
		
		// Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new Producer(sharedQueue), "producer");
		Thread consThread = new Thread(new Consumer(sharedQueue), "consumer 1");
		Thread consThread2 = new Thread(new Consumer(sharedQueue), "consumer 2");

		// Starting producer and Consumer thread
		prodThread.start();
		consThread.start();
		consThread2.start();
	}
}
