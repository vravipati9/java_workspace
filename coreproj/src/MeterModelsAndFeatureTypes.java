import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum MeterModelsAndFeatureTypes { 

	ACTARIS(101, 102) {
		@Override
		public List<MeterModelFeatureType> getListOfFeatures() {
			return featureTypesForActaris;
		}
		@Override
		void initializeFeatureTypes() {
			featureTypesForActaris = new ArrayList<MeterModelFeatureType>();
			featureTypesForActaris.add(new MeterModelFeatureType(11, "abc"));
			featureTypesForActaris.add(new LoadProfile(12, "def"));
		}
	},
	ELSTER(103, 104) {
		@Override
		public List<MeterModelFeatureType> getListOfFeatures() {
			return featureTypesForElster;
		}
		@Override
		void initializeFeatureTypes() {
			featureTypesForElster = new ArrayList<MeterModelFeatureType>();
			featureTypesForElster.add(new MeterModelFeatureType(11, "abc"));
		}
	};

	private final List<Integer> values;

	private static List<MeterModelFeatureType> featureTypesForActaris;

	private static List<MeterModelFeatureType> featureTypesForElster;

	abstract void initializeFeatureTypes();

	abstract List<MeterModelFeatureType> getListOfFeatures();


	MeterModelsAndFeatureTypes(Integer ...values) {
		this.values = Arrays.asList(values);
	}

	public List<Integer> getValues() {
		return values;
	}

	static {
		for (MeterModelsAndFeatureTypes feature : EnumSet.allOf(MeterModelsAndFeatureTypes.class)) {
			feature.initializeFeatureTypes();
		}
	}

	public static MeterModelsAndFeatureTypes find(Integer meterModelId) {
		for (MeterModelsAndFeatureTypes lang : MeterModelsAndFeatureTypes.values()) {
			if (lang.getValues().contains(meterModelId)) {
				return lang;
			}
		}
		return null;
	}


}
