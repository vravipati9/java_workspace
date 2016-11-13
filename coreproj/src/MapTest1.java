import java.util.*;

class Hors {
	public Hors(String n) {
		name = n;
	}

	public String name;

	public boolean equals(Object o) {
		if ((o instanceof Hors) && (((Hors) o).name == name)) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		int len = name.length();
		System.out.println("HashCode..."+len);
		return len;
	}
}

class Donkey {
	public String name;
	public Donkey(String n) {
		this.name = n;
	}
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Donkey) && (((Donkey)obj).name == name)) {
			return true;
		} else {
			return false;
		}
	}
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int n = super.hashCode();
		System.out.println("HashCode>>>"+n);
		return n;
	}
}

enum Pets {
	HORSE, ZEBRA, DONKEY
}

class MapTest1 {
	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
//		m.put(new Hors("Horse one"), "Hors one");
//		m.put(new Hors("Horse two"), "Hors two");
//		m.put(new Hors("Horse one"), "Hors one");
//		System.out.println(m.size());	// In this case the size of map is 2, it implements both equls and Hashcode
//		m.clear();

		m.put(new Donkey("Donkey one"), "Donkey one");
		m.put(new Donkey("Donkey one"), "Donkey two");
		Donkey d1 = new Donkey("Clover");
		m.put(d1, "Donkey one 1");
		System.out.println(m.size());	// In this case the size of map is 3, it implements both equls and Hashcode
		System.out.println(m.get(d1));
		d1.name = "magnolia";
		System.out.println(m.get(d1)); // #1
		d1.name = "clover";
		System.out.println(m.get(new Donkey("clover"))); // #2
		d1.name = "arthur";
		System.out.println(m.get(new Donkey("clover"))); // #3
		
	}
}