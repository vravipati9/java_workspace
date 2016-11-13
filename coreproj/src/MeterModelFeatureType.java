
public class MeterModelFeatureType {
	private Integer featureId;
	private String featureName;
	public Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	
	public MeterModelFeatureType(Integer featureId, String featureName) {
		this.featureId = featureId;
		this.featureName = featureName;
	}
	@Override
	public String toString() {
		return "Feature [featureId=" + featureId + ", featureName="
				+ featureName + "]";
	}
	
	
}
