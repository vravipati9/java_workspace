import java.util.ArrayList;
import java.util.List;

abstract class AnimalsPoly1 {
	public abstract void checkup();
	
	public AnimalsPoly1() {
		System.out.println("Default constructor in AnimalsPoly");
	}
}
class DogPoly1 extends AnimalsPoly1 {
	@Override
	public void checkup() {
		System.out.println("Dog Checkup");
	}
}
class CatPoly1 extends AnimalsPoly1 {
	@Override
	public void checkup() {
		System.out.println("Cat Checkup");
	}
}


class AnimalDoctor1 {
	public static void checkAnimals(AnimalsPoly1[] animalsObj) {
		for (AnimalsPoly1 animalsPoly : animalsObj) {
			animalsPoly.checkup();
		}
	}
	public static void checkAnimalsList(List<AnimalsPoly1> animalsObj) {
		for (AnimalsPoly1 animalsPoly : animalsObj) {
			animalsPoly.checkup();
		}
	}
}

public class ArrayStoreExceptionEx {
	public static void main(String a[]) {
		//addAnimals(dogList);
		
		DogPoly1[] dogs = new DogPoly1[3];
		addAnimals(dogs);	// Calling this we get ArrayStoreException at Runtime, because passing Dog obj and assigning Cat obj
		
		List<DogPoly1> dogList = new ArrayList<DogPoly1>();
		List<AnimalsPoly1> animalList = new ArrayList<AnimalsPoly1>();
		addAnimals(dogList);
		addAnimals(animalList);
	}
	
	static void addAnimals(AnimalsPoly1[] addAnimals) {
		addAnimals[0] = new CatPoly1();
		addAnimals[0] = new DogPoly1();
	}
	
	static void addAnimals(List<? super DogPoly1> list) {

	}
	
}

