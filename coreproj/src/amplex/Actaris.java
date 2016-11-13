package amplex;

public class Actaris extends MeterModel {
	@Override
	public FeatureType getFeatureTypeInstance(String str) {
		// TODO Auto-generated method stub
		System.out.println("*********Actaris MeterModel*********");
		return new LoadProfile();
	}
}
