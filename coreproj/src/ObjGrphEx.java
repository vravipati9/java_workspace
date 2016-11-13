class House {
	public House() {
		System.out.println("House constructor  :");
	}
	public House(String str) {
		System.out.println("House parameterized constructor");
	}
	String houseName = "abc";
	Room room = new Room();
}

class Room {
	public Room() {
		System.out.println("Room default constructor");
	}
	public Room(String name) {
		System.out.println("Room parameterized constructor");
	}
}

public class ObjGrphEx {
	public static void main(String[] args) {
		House house = new House();
		//Room room = new Room();
	}
}
