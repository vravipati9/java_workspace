class Animal {
	public void eat() {
		System.out.println("Generic Animal Eating Generically");
	}
}

class Horse extends Animal {
	public static final int HORSE_WEIGHT = 200;

	@Override
	public void eat() {
		System.out.println("Horse eating hay ");
	}

	public void eat(String s) {
		System.out.println("Horse eating " + s);
	}
}

class UseAnimals {
	public void doStuff(Animal a) {
		System.out.println("In the Animal version");
		if (a instanceof Horse) {
			System.out.println("Passing obj instance of Horse");
		}
		if (a instanceof Animal) {
			System.out.println("Passing obj instance of Animal");
		}
	}

	public void doStuff(Horse h) {
		System.out.println("In the Horse version");
	}

	public static void main(String[] args) {
		UseAnimals ua = new UseAnimals();
		Animal animalObj = new Animal();
		Horse horseObj = new Horse();
		Animal animalRefHorseObj = new Horse(); 
		ua.doStuff(animalObj);
		ua.doStuff(horseObj);
		ua.doStuff(animalRefHorseObj);		
	}
}

