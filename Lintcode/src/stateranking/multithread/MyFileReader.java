package stateranking.multithread;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

public class MyFileReader implements Runnable {

	private RandomAccessFile raf;
    private CountDownLatch doneSignal;
    private final int bufLen = 256;
    private String path;
	private File file;
	public MyFileReader(File f) {
		file = f;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
            raf = new RandomAccessFile(path,"rw");
            raf.seek(0);
            long contentLen = new File(path).length();
            long times = contentLen / bufLen +1;
            byte []buff = new byte[bufLen];
            int hasRead = 0;
            String result = null;
            for(int i=0;i<times;i++){
                hasRead = raf.read(buff);
                if(hasRead < 0){
                    break;
                }
                result = new String(buff,"gb2312");
            }
            doneSignal.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
