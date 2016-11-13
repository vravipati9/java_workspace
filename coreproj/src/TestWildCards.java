import java.util.ArrayList;
import java.util.List;

public class TestWildCards {
	public static void main(String a[]) {
		List<Animal2> animals = new ArrayList<Animal2>();
		animals.add(new Dog2());
		animals.add(new Dog2());
		
		addAnimal(animals); // passing an Animal List
}
	static void addAnimal(List<Animal2> list) {
		list.add(new Cat2());
	}
}
class Bar {
	void doInsert(List<?> list) {
		//list.add(new Dog2());
	}
}