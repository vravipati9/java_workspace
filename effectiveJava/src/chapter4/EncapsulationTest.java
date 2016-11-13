package chapter4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class EncapsulationTest implements Runnable {
	public static void main(String a[]) throws InterruptedException {
		/*Thing[] thing = Thing.getValArray();
		thing[0].setCount(5);
		System.out.println(thing[0].getCount());
		
		List<Thing> thingsList = Thing.VALUES_LIST;
		thingsList.add(0, new Thing(4));
		System.out.println(thingsList);
		*/
		Thread t1 = new Thread(new EncapsulationTest(), "TOne");
		Thread t2 = new Thread(new EncapsulationTest(), "TTwo");
		Thread t3 = new Thread(new EncapsulationTest(), "TTwo");
		t1.start();
		//t2.start();
		//t3.start();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run method called by ..."+Thread.currentThread().getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
		System.out.println(Calendar.getInstance().getTime());
	}
}
