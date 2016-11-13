package myownInjection;

import java.lang.reflect.Field;



public class MyOwnInjection {
	public static void main(String a[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("myownInjection.Presenter");
		Object outerObj = clazz.newInstance();
		System.out.println("Outer Obect-----"+outerObj);
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			PleaseInject annotation = field.getAnnotation(PleaseInject.class);
			if (annotation != null) {
				Class<?> type = field.getType();
				System.out.println(type.getModifiers());
				
				System.out.println("Annotated Class...."+type);
				Object annotedField = type.newInstance();
				System.out.println("rightSide----------"+annotedField);
				field.set(outerObj, annotedField);
			}
		}
		System.out.println("-----Injected Object--------"+outerObj);
	}
}
