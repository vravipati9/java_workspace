
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serialization1 {
	public static void main(String[] args) {
		Cates c = new Cates(20,5);
		try {
			FileOutputStream fos = new FileOutputStream("d:/testSer.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("d:/testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cates cObj =(Cates)ois.readObject();
			System.out.println("height	: "+cObj.height+"	weight	:"+cObj.weight);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
