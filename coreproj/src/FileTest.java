import java.io.File;


public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = {"D:\\certifications\\"};
		
		System.out.println(doesFileExist(str, "abc.txt"));

	}
	public static boolean doesFileExist(String[] directories, String filename) {
		System.out.println("asdfasf");
		String path = "";
		for( String dir : directories) {
		path = dir;
		File file = new File(path, filename);
		System.out.println(path);
		return file.exists();

		}
		return false;
		}
}
