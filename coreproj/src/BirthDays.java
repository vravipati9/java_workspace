import java.util.*;
public class BirthDays {
	public static void main(String[] args) {
		Map<Friend, String> map = new HashMap<Friend, String>();
		map.put(new Friend("Bobs"), "Jan");
		map.put(new Friend("Tom"), "Feb");

		Friend newFriend = new Friend("Tom");
		String name = map.get(newFriend);
		System.out.println(name);
	}
}

class Friend {
	public String name;
	public String age;
	
	Friend(String name) {
		this.name = name;
	}
	
	Friend(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println("hashCode...."+result);
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
		Friend other = (Friend) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
