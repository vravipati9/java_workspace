package adapter;

public class AdapterPatternTest {
	public static void main(String[] args) {
		Chargeable charger = new AppleCharger();
		charger.setMobileName("IPhone6");
		ChargerUtils.doCharge(charger);
		
		Charger samsungCharger = new SamsungCharger();
		samsungCharger.setMobileName("Galaxy Note 3");
		
		AppleAdapter adapter = new AppleAdapter();
		adapter.setSamsungCharger(samsungCharger);
		ChargerUtils.doCharge(adapter);
	}
}
