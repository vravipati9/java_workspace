public class InnerAnonymos2 {

	public static void main(String[] args) {
		go();
	}
	public static void go() {
		Food1 f = new Food1();
		f.doStuff(new Popcorn1() {
			
			public void pop() {
				System.out.println("Inner cls pop method implemented.");
			}
		});
	}
}
interface Popcorn1 {
	void pop();
}
class Food1 {
	void doStuff(Popcorn1 pc) {
		System.out.println("doStuff in food");
		pc.pop();
	}
}
