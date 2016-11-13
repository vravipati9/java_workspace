import java.io.IOException;

public class Excep5 {
	static void test() throws IOException {
		try {
			System.out.print("test ");
			throw new RuntimeException();
		} catch (RuntimeException ex) {
			System.out.print("exception ");
			throw ex;
		}
	}

	public static void main(String[] args) {
		try {
			test();
		} catch (IOException i) {
			System.out.print("IOException "+i);
		}
		catch (RuntimeException ex) {
			System.out.print("runtime "+ex);
		} 
		catch (Exception e) {
			System.out.print("Generic Exception");
		
		System.out.print("end ");
	}
	}
}
	
// test runtime end
// test generic end