import java.io.*;

class KeyboardPlayer {
}

public class ComputerPlayer implements Serializable {
	private KeyboardPlayer k = new KeyboardPlayer();

	public static void main(String[] args) {
		ComputerPlayer c = new ComputerPlayer();
		c.storeIt(c);
	}

	void storeIt(ComputerPlayer c) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("myFile"));
			os.writeObject(c);
			os.close();
			System.out.println("done");
		} catch (Exception x) {
			System.out.println("exc"+x);
		}
	}
}