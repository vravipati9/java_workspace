import java.io.IOException;

public class Excep9 {
	public static void main(String[] args) {
		try {
			start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {	//it generates catch block we change order for IOException
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void start() throws IOException, RuntimeException{
		//throw new RuntimeException("Not able to start");
		throw new IOException();
	}
}


