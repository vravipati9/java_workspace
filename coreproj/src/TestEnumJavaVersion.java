
public class TestEnumJavaVersion {
	public static final String MALE = "M";
	public static void main(String a[]) {
		String gender = "M";
		System.out.println(MALE == gender);
		System.out.println("EnumJavaVersion.JDK1_0       "+EnumJavaVersion.JDK1_0.getID());
		System.out.println("Current VErsion Name		"+EnumJavaVersion.getCurrentVersionName());
		System.out.println("EnumJavaVersion.getJavaVersion7	"+EnumJavaVersion.getJavaVersion("1.7"));
		System.out.println(EnumJavaVersion.getField(7));
	}
}