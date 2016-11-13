package abstractfactory;

import java.io.IOException;

public class AbstractFactoryTest {
	public static void main(String[] args) throws IOException {
		CarFactory hondaCarFactory = FactoryProducer.getCarFactory("honda");
		Car brio = hondaCarFactory.createCar("brio");
		brio.drive();
		
		try {
			throw new IOException();
		}  finally {
			
		}
	}
} 
