package javabeanDataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestBeanFactory {
	public static Collection generateCollection() {
		List<PersonBean> collection = new ArrayList<PersonBean>();
		collection.add(new PersonBean("Ram", 11));
		collection.add(new PersonBean("Rober", 14));
		collection.add(new PersonBean("Rahim", 31));
		collection.add(new PersonBean("Jain", 12));
		return collection;
	}
	
	public static PersonBean[] generatePersonBeanArray() {
		PersonBean personBean[] = new PersonBean[6];
		personBean[0] = new PersonBean("Ram", 11);
		personBean[0] = new PersonBean("Rober", 14);
		personBean[0] = new PersonBean("Rahim", 31);
		personBean[0] = new PersonBean("Jain", 12);
		return personBean;
	}
}
