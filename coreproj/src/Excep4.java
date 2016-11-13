import java.io.IOException;

public class Excep4 {

	public static void main(String[] args) throws IOException{
		System.out.println("before Calling");
		try {
			go();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("After Calling");
	}
	static void go() throws IOException {
		if (true) {
			throw new IOException();
		}
	}

}
