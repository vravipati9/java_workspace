import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;


public class SortWithTwoProperties implements Comparator<Person>{
	public static void main(String a[]) {
		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person("Sam", "25");
		Person p2 = new Person("Sunder", "27");
		Person p3 = new Person("Sam", "26"); 
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		Collections.sort(list, new SortWithTwoProperties());
		
		System.out.println("After Sort");
		for (Person person : list) {
			System.out.println(person.getName() +"	"+person.getAge());
		}
		System.out.println("============");
		TreeMap<Person, String> treeMap = new TreeMap<Person, String>();
		treeMap.put(p1, "Person1"); // will not throw any exception, becoz it has one element now
		//treeMap.put(p2, "Person2");java.lang.ClassCastException: Person cannot be cast to java.lang.Comparable
		System.out.println(treeMap);
				
	}

	@Override
	public int compare(Person o1, Person o2) {
		int result = 0;
		// use Integer class's natural ordering
		result = o1.getName().compareTo(o2.getName());
		// if names are same compare by petType
		if (result == 0) {
			result = o1.getAge().compareTo(o2.getAge());
		}
		return result;
	}
}

class Person{

    private String name;
    private String age;
    
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
}