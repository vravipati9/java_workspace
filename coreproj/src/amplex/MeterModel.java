package amplex;

import java.util.HashMap;
import java.util.Map;

public class MeterModel {
	public FeatureType getFeatureTypeInstance(String str) {
		 throw new UnsupportedOperationException();
	}
	
	private static Map<String, ? super MeterModel> map = null;

	  static {
	    map = new HashMap<String, MeterModel>();
	    map.put("Actaris", new Actaris());
	  }

	  public final static MeterModel getMeterModelInstance(String model) {
	/*    MeterModel meterModel = map.get(model);
	    if (meterModel == null)
	      throw new RuntimeException("no handler for state " + meterModel);
	    */
		  System.out.println("****MeterModelFactory getMeterModel()****");
		  return new Actaris();  
	  }
}
