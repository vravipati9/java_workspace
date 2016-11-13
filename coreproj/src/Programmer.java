import java.util.ArrayList;
import java.util.List;

public class Programmer implements Cloneable {
	private String name;
	private int age;
	private List certifications;

	public Programmer(String name, int age) {
		this.name = name;
		this.age = age;
		this.certifications = new ArrayList();
	}

	public void addCertificates(String certs) {
		certifications.add(certs);
	}

	@Override
	public String toString() {
		return String.format("%s, %d, Certifications: %s", name, age,
				certifications.toString());
	}

	@Override
	protected Programmer clone() {
		Programmer clone = null;
		try {
			clone = (Programmer) super.clone();
			clone.certifications = new ArrayList(certifications);
			// deep copying
		} catch (CloneNotSupportedException cns) {
			System.out.println("Error while cloning programmer"+cns);
		}
		return clone;
	}
}
