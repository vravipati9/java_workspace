package abstractfactory;

public class FactoryProducer {
	public static CarFactory getCarFactory(String factoryType) {
		if(factoryType.equalsIgnoreCase("hundai")) {
			return new HundaiCarFactory();
		} else if(factoryType.equalsIgnoreCase("honda")) {
			return new HondaCarFactory();
		}
		return null;
	}
}
