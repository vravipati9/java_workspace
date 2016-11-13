import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class MakeFileReadOnly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\rsr\\hosts.txt");
		f.setReadOnly();
		if (f.canWrite())  {
			System.out.println("aasdfasdfasfasf");
		} else {
			System.out.println("--------");
		}
	}
}
