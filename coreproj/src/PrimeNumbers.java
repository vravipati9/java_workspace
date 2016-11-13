
public class PrimeNumbers {
	public static void main(String[] args) {
		int temp = 1;
		for (int i=1;i<=50;i++) {
			int count = 0;
			for(int j=1;j<=i;j++) {
				if (i%j == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.print("\t"+i);		
			}
		}
		
	}

}
