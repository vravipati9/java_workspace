package amplex;

public class TestInheritence {
	public static void main(String a[]) {
		MeterModel meterModel = MeterModel.getMeterModelInstance("Actaris");
		FeatureType featureType = meterModel.getFeatureTypeInstance("loadProfile");
		FeatureType fp = featureType.constructMeterFeatureTypeObj(featureType);
	}
}
