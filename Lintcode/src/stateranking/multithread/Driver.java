package stateranking.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path states = Paths.get("src\\stateranking\\states\\Massachusetts");
		Thread t1 = new Thread(new MyFileReader(states));
		t1.start();
	}

}
