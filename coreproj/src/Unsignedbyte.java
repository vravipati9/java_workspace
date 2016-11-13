import java.math.BigInteger;


public class Unsignedbyte {

	public static void main(String[] args) {
		//byte signedByte = 15;
		//int unsignedByte = signedByte & (0xff);
		//System.out.println("Signed: " + signedByte + " Unsigned: " + unsignedByte);
		byte[] arr = new byte[] {15};
		printBytesAsHex(arr);
		int month = 3;
		BigInteger.valueOf(month+1);
		System.out.println(BigInteger.valueOf(month+1));
		
	}
	
	private static void printBytesAsHex(byte[] bytes)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i=0; i<bytes.length; i++) {
			int j = 0xFF & bytes[i];
			if (j < 16)
				buffer.append("0");
			buffer.append(Integer.toHexString(j).toUpperCase());
		}
		System.out.println(buffer);
	}
}
