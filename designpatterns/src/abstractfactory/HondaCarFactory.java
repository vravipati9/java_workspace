package abstractfactory;

public class HondaCarFactory implements CarFactory{

	@Override
	public Car createCar(String carType) {
		// TODO Auto-generated method stub
		if(carType.equalsIgnoreCase("brio")) {
			return new Brio();
		} else if(carType.equalsIgnoreCase("city")) {
			return new City();
		}
		return null;
	}

}
