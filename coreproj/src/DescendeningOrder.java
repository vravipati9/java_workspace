import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DescendeningOrder {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(8);
		Collections.sort(l);
		Collections.reverse(l);
		System.out.println(l);
		for (int i = l.size()-1; i >= 0; i--	) {
			System.out.println(l.get(i));
		}
		
		for (ListIterator iterator = l.listIterator(l.size()); iterator.hasPrevious();) {
			  final Object listElement = iterator.previous();
			  System.out.println(((Integer)listElement).intValue());
		}
		System.out.println(reverseStr(""));

		eleminateDuplicates() ;
	}
	
	static String reverseStr(String s) {
		String str = "siva";
		char c[] = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = c.length-1; i >= 0; i--) {
			//char d = c[i];
			sb.append(c[i]);
		}
		
		return sb.toString();
	}
	
	static void eleminateDuplicates() {
		DescendeningOrder.Room obj = new DescendeningOrder.Room("1","one");
	}
	static class Room {
		private String roomId;
		private String roomName;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((roomName == null) ? 0 : roomName.hashCode());
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
			Room other = (Room) obj;
			if (roomName == null) {
				if (other.roomName != null)
					return false;
			} else if (!roomName.equals(other.roomName))
				return false;
			return true;
		}
		
		public Room(String roomId, String roomName) {
			this.setRoomId(roomId);
			this.roomName = roomName;
		}
		public String getRoomId() {
			return roomId;
		}
		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}
	}
}

