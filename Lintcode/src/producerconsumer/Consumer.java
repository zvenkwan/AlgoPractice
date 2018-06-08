package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
        System.out.println("	starting  " +  Thread.currentThread().getName());
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
        	while(!sharedQueue.isEmpty()) {
        		System.out.println("	Consumed: "+ sharedQueue.take() + " by " + Thread.currentThread().getName());
        		Thread.sleep(2000);
        		if(sharedQueue.isEmpty()) {
        			System.out.println(" no work to do, I will wait for 6 seconds");
        			int j = 6;
        			while(j-- > 0) {
        				System.out.println("counting down " + j);
        				Thread.sleep(1000);
        			}
        		} 
        	}
        } catch (InterruptedException ex) {
        }
	}

}
