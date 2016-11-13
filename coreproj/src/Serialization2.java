import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Doges implements Serializable {
	transient private Collar theCollar;
	transient int intDefaultVal;
	static String strDefaultVal;
	private int dogSize;

	public Doges(Collar collar, int size) {
		theCollar = collar;
		dogSize = size;
	}

	public int getDogSize() {
		return dogSize;
	}

	public void setDogSize(int dogSize) {
		this.dogSize = dogSize;
	}

	public Collar getCollar() {
		return theCollar;
	}
	// If we want to serialize some parts of transient object, we can write below method(syntax is same)
	private void writeObject(ObjectOutputStream os) {
		// throws IOException { // 1
		try {
			System.out.println("11");
			os.defaultWriteObject(); // Normal Serialization
			//System.out.println("writeobj()..."+theCollar.getCollarSize());
			System.out.println("22");
			os.writeInt(theCollar.getCollarSize()); // parts of transient object serialization.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream is) {
		// throws IOException, ClassNotFoundException { // 4
		try {
			is.defaultReadObject(); // 5
			//System.out.println("In read  :" +is.readInt());
			theCollar = new Collar(is.readInt());
			System.out.println("after read  :"+theCollar.getCollarSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Collar {
	private int collarSize;

	public Collar(int size) {
		collarSize = size;
	}

	public int getCollarSize() {
		return collarSize;
	}

	public void setCollarSize(int collarSize) {
		this.collarSize = collarSize;
	}	
}

public class Serialization2 {
	public static void main(String[] args) {
		Collar c = new Collar(5);
		Doges d = new Doges(c, 8);
		try {
			FileOutputStream fos = new FileOutputStream("d:/testSer.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("1");
			oos.writeObject(d);
			System.out.println("2");
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream("d:/testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Doges cObj =(Doges)ois.readObject();
			System.out.println("CollarSize "+cObj.getCollar().getCollarSize());
			System.out.println("DogSize "+cObj.getDogSize());
			System.out.println("Default Int value "+cObj.intDefaultVal);
			System.out.println("Default Str value "+cObj.strDefaultVal);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
