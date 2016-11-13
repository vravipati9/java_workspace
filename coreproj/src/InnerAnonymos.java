/*
 * Anonymous Inner class
 */
public class InnerAnonymos {
	public static void main(String[] args) {
		Food food = new Food();
		food.pc.pop();
		food.popIt();

	}
}

class PopCorn {
	void pop() {
		System.out.println("pop method");
	}
}
class Food {
	PopCorn pc = new PopCorn() {
		void pop() {
			System.out.println("Inner cls POP method.");
		}
		void size () {
			System.out.println("Inner cls Size method.");
		}
	};
	void popIt() {
		System.out.println("popIt method");
		pc.pop();
		//pc.size();
	}
}

