package decorator;

public class PanPizza implements Pizza{

	@Override
	public String description(String name) {
		return name;
	}

	@Override
	public double cost() {
		return 10;
	}
}
