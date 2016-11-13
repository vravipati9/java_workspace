package annotattions;

import java.util.HashMap;
import java.util.Map;

// @Generated(value="by my generator", date="12/15/1966", comments="DO NOT EDIT")'
@Observer
@Copyright(text = "")
public class Foo {

	private final Map<Class<?>, Object> services = new HashMap<Class<?>, Object>();

	public static class Fee extends Foo {
		public void foo() {
			// override whatever it is
		}
	}

	@Deprecated
	public void foo() {
		//...
	}

	public static void main(String[] args) {
	}

	public <T> T get(Class<?> serviceType) {
		@SuppressWarnings("unchecked")
		T result = (T) services.get(serviceType);
		return result;
	}

	@Test(order=2)
	public void foo1() {
		System.out.println("foo1");
	}
	public void foo2() {
		System.out.println("foo2");
	}
	@Test(order=1)
	public void foo3() {
		System.out.println("foo3");
	}
	public void foo4() {
		System.out.println("foo4");
	}
	
}
