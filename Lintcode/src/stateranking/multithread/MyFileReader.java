package stateranking.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class MyFileReader implements Runnable {
//public class MyFileReader implements Callable {
	private Map<String, Integer> map;
    private Path path;
	public MyFileReader(Path path) {
		this.path = path;
		map = new HashMap<String, Integer>();
	}
	public void run() {
		// TODO Auto-generated method stub
		int edu = 0, pol = 0, spr = 0, agr = 0;
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
//	@Override
//	public MyFileReader call() throws Exception {
//		// TODO Auto-generated method stub
//				int edu = 0, pol = 0, spr = 0, agr = 0;
//				try (BufferedReader br = Files.newBufferedReader(path)){
//					String currentLine = null;
//					while((currentLine = br.readLine()) != null) {
//						String[] words = currentLine.toLowerCase().split("\\W+");
//						for(String word: words) {
//							switch(word) {
//							case "education":
//								edu++;
//								break;
//							case "politics":
//								pol++;
//								break;
//							case "sports":
//								spr++;
//								break;
//							case "agriculture":
//								agr++;
//								break;
//							}
//						}
//					}
//					map.put("education", edu);
//					map.put("politics", pol);
//					map.put("sports", spr);
//					map.put("agriculture", agr);
//					System.out.println(path.getFileName());
//					System.out.println(map);
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//				return this;
//	}

}
