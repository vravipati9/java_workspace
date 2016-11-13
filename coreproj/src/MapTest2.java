import java.util.*;

public class MapTest2 {
	public static void main(String[] args) {
		int aa = 900000000;
	Map myMap = new HashMap(10);
	String s = "asda";
	UserKey uk1 = new UserKey("John");
	myMap.put(uk1, "Sydney");
	uk1.setName("Sam");
	myMap.put(uk1, "Melborne");
	
	Set set = myMap.keySet();
	for (Object object : set) {
		System.out.println(((UserKey)object).toString());
	}
	System.out.println("Map Size..."+myMap.size());
	System.out.println(myMap.get(new UserKey("Sam")));
	System.out.println(myMap.get("John"));
	
	
	}
}

final class UserKey {
	private String name = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserKey(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		
		System.out.println("hashcode value>>>s"+result);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserKey other = (UserKey) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserKey [name=" + name + "]";
	}
	
}

