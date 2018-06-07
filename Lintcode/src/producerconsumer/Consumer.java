package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
        	while(true) {
        		System.out.println("	Consumed: "+ sharedQueue.take());
        		Thread.sleep(3000);
        	}
        } catch (InterruptedException ex) {
        }
	}

}
