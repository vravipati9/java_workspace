package chapter6;

public class OrdinalMethodEnum {

	public static void main(String[] args) {
		System.out.println(Ordinal.TRIO.ordinal());
	}
}
enum Ordinal {
	SOLO, DUET, TRIO, QUARTET, QUINTET,
	SEXTET, SEPTET, OCTET, NONET, DECTET;
	
	public int numberOfMusicians() { return ordinal() + 1; }
}
