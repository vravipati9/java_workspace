package chapter4;

public class SimulatedMultipleInheritance implements IOne,ITwo {

	public static void main(String[] args) {
		
	}

	@Override
	public void mOne() {
		System.out.println("MOne");
	}
}

interface IOne {
	public void mOne();
}

interface ITwo {
	public void mOne();
}
