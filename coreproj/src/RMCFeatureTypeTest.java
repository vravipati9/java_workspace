import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMCFeatureTypeTest {

	public static void main(String[] args) {
		populateMeterModuleACE5000();
	}
	static private void populateMeterModuleACE5000() {
		List<MeterModelFeatureType> list = MeterModelsAndFeatureTypes.find(101).getListOfFeatures();
		System.out.println(list);
	}
}
