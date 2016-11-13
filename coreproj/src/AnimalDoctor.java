import java.util.ArrayList;
import java.util.List;

abstract class Animal2 {
	public abstract void checkup();
}

class Dog2 extends Animal2 {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}
}
class Cat2 extends Animal2 {
	public void checkup() { // implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird2 extends Animal2 {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}

public class AnimalDoctor {
	// method takes an array of any animal subtype
	public void checkAnimals(Animal2[] animals) {
		for (Animal2 a : animals) {
			a.checkup();
		}
	}
	public void checkAnimal(ArrayList<Animal2> animals) {
		for(Animal2 a : animals) {
			a.checkup();
		}
	}
	public static void main(String[] args) {
		AnimalDoctor doc1 = new AnimalDoctor();
		List<Animal2> animals1 = new ArrayList<Animal2>();
		animals1.add(new Dog2());
		//doc1.checkAnimal(animals1);
		addAnimal(animals1);
		Dog2[] dog = { new Dog2(), new Dog2() };
		addAnimal(dog);
//		Cat2[] cats = { new Cat2(), new Cat2(), new Cat2() };
//		Bird2[] birds = { new Bird2() };

		doc1.checkAnimals(dog); // pass the Dog[]
//		doc.checkAnimals(cats); // pass the Cat[]
//		doc.checkAnimals(birds); // pass the Bird[]
		
		List<Dog2> dogs = new ArrayList<Dog2>();
		dogs.add(new Dog2());
		dogs.add(new Dog2());
		List<Cat2> cats = new ArrayList<Cat2>();
		cats.add(new Cat2());
		cats.add(new Cat2());
		List<Bird2> birds = new ArrayList<Bird2>();
		birds.add(new Bird2());
		// this code is the same as the Array version
		AnimalDoctor doc = new AnimalDoctor();
		// this worked when we used arrays instead of ArrayLists
//		doc.checkAnimals(dogs); 
//		doc.checkAnimals(cats); 
//		doc.checkAnimals(birds);
		
		List<Animal2> animals = new ArrayList<Animal2>();
		animals.add(new Cat2()); // OK
		animals.add(new Dog2()); // OK
		addAnimal(animals);
		
	}
	
	public static void addAnimal(Animal2[] animals) {
		animals[0] = new Dog2(); // no problem, any Animal works in Animal[]
		//animals[0] = new Cat2();  // get ArrayStoreException
	}
	
	public static void addAnimal(List<Animal2> animals) {
		animals.add(new Dog2()); // no problem, any Animal works
		animals.add(new Cat2());
	}
}
