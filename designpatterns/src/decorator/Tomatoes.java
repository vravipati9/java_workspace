package decorator;

public class Tomatoes extends PizzaToppings {

	public Tomatoes(Pizza pizza) {
		this.pizza = pizza;
	}
	@Override
	public String description(String name) {
		return name;
	}


	@Override
	public double cost() {
		return pizza.cost()+1.0;
	}
}
