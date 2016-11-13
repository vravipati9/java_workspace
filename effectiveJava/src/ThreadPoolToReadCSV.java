import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolToReadCSV {

	public static void main(String[] args) throws IOException {

		String fName = "D:\\data.csv";
		String thisLine;
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		ExecutorService pool = Executors.newFixedThreadPool(10);

		while ((thisLine = myInput.readLine()) != null) {
			pool.submit(new MyTask(thisLine));
		}
	}
}

class MyTask implements Runnable {
    private String lLine;
    public MyTask(String line) {
         this.lLine=line;

    }

    public void run() {
    	System.out.println(Thread.currentThread().getName());
        // 1) Create Request  lLine
        // 2) send the HTTP request out and receive response
    }
}