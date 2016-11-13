package annotattions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
	private static class TestMethod {
		
		private final Method method;
		private final int order;
		public Method getMethod() {
			return method;
		}
		public int getOrder() {
			return order;
		}
		public TestMethod(Method method, int order) {
			this.method = method;
			this.order = order;
		}
	}
	public static void main(String[] args) throws Throwable {
		String className = args[0];
		Class<?> c = Class.forName(className);
		Method[] methods = c.getDeclaredMethods();
		List<TestMethod> testMethods = new ArrayList<TestMethod>();
		for (Method method : methods) {
			Test test = method.getAnnotation(Test.class);
			if (test == null) {
				continue;
			}
			testMethods.add(new TestMethod(method, test.order()));
		}
		Collections.sort(testMethods, new Comparator<TestMethod>() {
			@Override
			public int compare(TestMethod o1, TestMethod o2) {
				return o1.getOrder() - o2.getOrder();
			}
		});
		for (TestMethod testMethod : testMethods) {
			Object object = c.newInstance();
			testMethod.getMethod().invoke(object);
		}
	}
}
