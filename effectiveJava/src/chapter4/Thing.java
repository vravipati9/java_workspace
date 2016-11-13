package chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Thing {
	private int count;
	private static final Thing[] VAL_ARRAY = {new Thing(2), new Thing(3)};
	public static final List<Thing> VALUES_LIST = Collections.unmodifiableList(Arrays.asList(VAL_ARRAY));
		
	
	public Thing(int count) {
		this.count = count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}

	public static Thing[] getValArray() {
		return VAL_ARRAY;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(count);
	}
	
}
