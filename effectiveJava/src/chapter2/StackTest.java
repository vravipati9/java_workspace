package chapter2;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		System.out.println("Stack Size:::"+stack.size()+"    Stack Lenght:::"+stack.getElements().length);
		System.out.println("remove element from top:::"+stack.pop());
		stack.pop(stack.size()+1);
		System.out.println("Stack Size:::"+stack.size());
	}

}
