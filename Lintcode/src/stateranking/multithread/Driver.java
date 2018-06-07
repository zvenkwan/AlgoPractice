package stateranking.multithread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
		Path states = Paths.get("src\\stateranking\\states");
//		try {
//			ExecutorService es = Executors.newFixedThreadPool(50);
//			Files.list(states).map(path ->  new MyFileReader(path)).map(reader -> es.submit(reader)).collect(Collectors.toList());
////			while(!es.awaitTermination(1, TimeUnit.MICROSECONDS)){
////			System.out.println("not completed");
////			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			ExecutorService es = Executors.newFixedThreadPool(16);
			Files.list(states).parallel().map(path -> new MyFileReader(path)).map(reader -> es.submit(reader)).collect(Collectors.toList());
			es.shutdown();
			while(!es.awaitTermination(1, TimeUnit.SECONDS)){
				System.out.println("not completed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println(end-start);
//		749898495
	}

}

