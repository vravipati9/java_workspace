package decorator;

public class DecoratorPatternTest {
	public static void main(String[] args) {
		Pizza panPizza = new PanPizza();
		panPizza = new Tomatoes(panPizza);
		panPizza = new Cheese(panPizza);
		System.out.println("You ordered PanPizza :::");
		System.out.println("Your total cost::"+panPizza.cost());
	}
}
