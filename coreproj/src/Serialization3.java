import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Anmals {
	int weight = 42;
}

class Dugs extends Anmals implements Serializable {
	public String name;
	public int height = 12;

	Dugs(int w, String n, int h) {
		System.out.println("Calling consturctor");
		weight = w; // inherited
		name = n; // not inherited
		height = h;
	}
}

public class Serialization3 {
	public static void main(String[] args) throws Exception {
		Serialization3 s1 = new Serialization3();
		Dugs d = new Dugs(35, "Fido", 10);
		System.out.println("before: " + d.name + " " + d.weight +" " +d.height);
		try {
			FileOutputStream fs = new FileOutputStream("d:/testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("d:/testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dugs) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: " + d.name + " " + d.weight	+" " +d.height);
	}
}
