public class StringEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Iam a boy";
		
		System.out.println("index..."+s.indexOf("siva"));
		Emp e = new Emp();
		System.out.println(e.name);
		System.out.println(e.number);
		
		String s1 = "ABCdeFgH";
		char[] charArr = s1.toCharArray();
		for(int i=0;i<s1.length();i++) {
			if (charArr[i] >= 'A' &&  charArr[i] >= 'Z') {
				System.out.print(charArr[i]);
			}
		}
	}

}

class Emp {
	String name = null;
	Integer number =null;
}
