package stateranking.singlethread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import stateranking.multithread.MyFileReader;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path states = Paths.get("src\\stateranking\\states");
		try {
//			List<MyFileReader> readers = Files.list(states).map(path ->  new MyFileReader(path)).collect(Collectors.toList());
			List<Path> paths = Files.list(states).collect(Collectors.toList());
			for(Path path : paths) {
				int edu = 0, pol = 0, spr = 0, agr = 0;
				Map<String, Integer> map = new HashMap<String, Integer>();
				try (BufferedReader br = Files.newBufferedReader(path)){
					String currentLine = null;
					while((currentLine = br.readLine()) != null) {
						String[] words = currentLine.toLowerCase().split("\\W+");
						for(String word: words) {
							switch(word) {
							case "education":
								edu++;
								break;
							case "politics":
								pol++;
								break;
							case "sports":
								spr++;
								break;
							case "agriculture":
								agr++;
								break;
							}
						}
					}
					map.put("education", edu);
					map.put("politics", pol);
					map.put("sports", spr);
					map.put("agriculture", agr);
					System.out.println(path.getFileName());
					System.out.println(map);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t1 = new Thread(new MyFileReader(states));
		t1.start();
	}

}

