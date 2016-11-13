
public class DeepCloneTest {

	public static void main(String[] args) {
		Programmer programmer = new Programmer("John", 31); 
		programmer.addCertificates("OCPJP"); 
		programmer.addCertificates("OCMJD"); 
		programmer.addCertificates("PMP"); 
		programmer.addCertificates("CISM"); 
		System.out.println("Real Java Guru : {}"+programmer); 
		
		Programmer clone = programmer.clone(); 
		System.out.format("Clone of Java Guru : {}"+clone); 
		//let's add another certification to java guru 
		programmer.addCertificates("Oracle DBA"); 
		System.out.format("Real Java Guru : {}"+programmer); 
		System.out.format("Clone of Java Guru : {}"+clone);

	}
}
