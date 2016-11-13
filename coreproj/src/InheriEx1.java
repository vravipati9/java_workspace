class Supercla {
	int multiply(int a, int b) {
		return a*b;
	}
} 
class SubCla extends Supercla {
	int i = 0;
	int multiply(int a, int b) {
		//int i = super.multiply(a, b);
		return i;
	}
}
class ClassA {}
class ClassB extends ClassA {}
class ClassC extends ClassA {}


public class InheriEx1 {
	public static void main(String[] args) {
		ClassA p0 = new ClassA();
		ClassB p1 = new ClassB();
		ClassC p2 = new ClassC();
		ClassA p3 = new ClassB();
		ClassA p4 = new ClassC();
		p0 = p1;
		//p1 = p2;	//Below 3 are wrong
		//p2 = p4;
		//p2 = (ClassC)p1;
		p1 = (ClassB)p3;
		p2 = (ClassC)p4;
	}
}
