package abstractfactory;

public class HundaiCarFactory implements CarFactory{

	@Override
	public Car createCar(String carType) {
		// TODO Auto-generated method stub
		if(carType.equalsIgnoreCase("I10")) {
			return new I10();
		} else if(carType.equalsIgnoreCase("I20")) {
			return new I20();
		}
		return null;
	}

}
