package chapter6;
class ClassExecutionSequenceSuper {
	ClassExecutionSequenceSuper() {
		System.out.println("Super class Constructor");
	}
	ClassExecutionSequenceSuper(int i) {
		System.out.println("Super class Parameterized Constructor");
	}
	{
		System.out.println("Super class initialization block");
	}
	static {
		System.out.println("Super class Static block");
	}

}

public class ClassExecutionSequence extends ClassExecutionSequenceSuper {
	
	enum Sex {
		MALE, FEFAMLE;
	}
	public static void main(String[] args) {
		ClassExecutionSequence obj = new ClassExecutionSequence(10);
		for (Sex sex : Sex.values()) {
			System.out.println(sex);
		}
	}

	{
		System.out.println("initialization block");
	}
	
	static {
		System.out.println("Static block");
	}
	
	public ClassExecutionSequence() {
		System.out.println("Sub Class Default constructor");
	}

	public ClassExecutionSequence(int i) {
		System.out.println("Sub Class Parameterized constructor");
	}
}

/*
 *Static block
 *Super class static block
 *Super class Constructor
 *Super class initialization block
 *initialization block
 *Sub Class Parameterized constructor
 */
