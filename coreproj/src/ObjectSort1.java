import java.util.*;
import java.io.*; // populateList() needs this

public class ObjectSort1 {
	static ArrayList<DVDInfo> dvdlist = new ArrayList<DVDInfo>();

	public static void main(String[] args) {
		new ObjectSort1().go(dvdlist);
	}

	public void go(ArrayList<DVDInfo> dvdlist) {
		System.out.println("sava".compareTo("Sava"));
		ArrayList al = new ArrayList(2);
		
		populateList(dvdlist);
		
		System.out.println("Elements in Collection");
		System.out.println(dvdlist); 
		Collections.sort(dvdlist);
		System.out.println("Elements sorted by title");
		System.out.println(dvdlist); // output sorted by title
		GenreSort gs = new GenreSort();
		Collections.sort(dvdlist, gs);
		System.out.println("Elements sorted by genre");
		System.out.println(dvdlist); // output sorted by genre
	}

	private static void populateList(List<DVDInfo> list) {
		DVDInfo obj1 = new DVDInfo("SINGAM", "ACTION", "AJAYDEVGAN");
		DVDInfo obj2 = new DVDInfo("RAVAN", "FICTION", "SHARUKH");
		DVDInfo obj3 = new DVDInfo("READY", "COMEDY", "SALMAN");
		list.add(obj1);list.add(obj2);list.add(obj3);
	}
}