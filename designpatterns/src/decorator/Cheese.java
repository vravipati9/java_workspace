package decorator;

public class Cheese extends PizzaToppings {

	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}
	@Override
	public String description(String name) {
		return name;
	}

	@Override
	public double cost() {
		return pizza.cost()+2.0;
	}
}
