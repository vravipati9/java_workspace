import java.util.ArrayList;
import java.util.List;

public class NoClassDefFoundErrStaticInit {
	public static void main(String a[]) {
		//System.getProperty();
		
		System.out.println("java.class.path>>>"+System.getProperty("java.class.path"));
		System.out.println("java.classpath>>>"+System.getProperty("java.classpath"));
		List<Use> users = new ArrayList<Use>(2);

		for (int i = 0; i < 2; i++) {
			try {
				users.add(new Use(String.valueOf(i))); // will throw
														// NoClassDefFoundError
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}
}

class Use {
	private static String USER_ID = getUserId();

	public Use(String id) {
		this.USER_ID = id;
	}

	private static String getUserId() {
		throw new RuntimeException("UserId Not found");
		
	}
}