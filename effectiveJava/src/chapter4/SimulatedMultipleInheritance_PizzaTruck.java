package chapter4;

//Wrapper class is a class that wrap the another class 
//and provide the abstraction between client and the original class being wrapped 
class SimulatedMultipleInheritance_PizzaTruck extends Truck implements Kitchen {
	Kitchen kitchen;	
	public static void main(String[] args) {
		SimulatedMultipleInheritance_PizzaTruck pizzaTruck = new SimulatedMultipleInheritance_PizzaTruck();
		pizzaTruck.driveTo("Beach");
		pizzaTruck.cook();
	}
	public void cook() {
		kitchen.cook();
	}
}
abstract class Truck {
	void driveTo(String s) {
		System.out.println("Driving towards "+s);
	}
}

interface Kitchen {
	public void cook();
}