import java.util.ArrayList;
interface Generic {
	public void mOne();
}

class Computer {
	
}
class Mouse extends Computer {
	
}
class keyBoard extends Computer {
	keyBoard(String name) {
		this();
		System.out.println("done");
		
	}
	public keyBoard() {
		System.out.println("const called");
	}
}
public class GenericTypeEx5 {

	public static void main(String[] args) {
		ArrayList<Mouse> mouseList = new ArrayList<Mouse>();
		keyBoard k = new keyBoard("lenovo");
		mouseList.add(new Mouse());
		ArrayList genericList = mouseList;
		ArrayList<keyBoard> keyBoardList = genericList;
		keyBoardList.add(new keyBoard());
		System.out.println(keyBoardList);
		int []x[] = {{1,2}, {3,4,5}, {6,7,8,9}};
		int [][]y = x;
		System.out.println(y[2][1]);
	}

}
