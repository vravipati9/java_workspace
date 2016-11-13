import java.util.List;

public class ManifestSearchDTO {	
	private Long rotationNo;    
	private Integer containerNo;
    
    private String vesselName;  
    private String etaDate;
    
    private Integer bolNo;

    private String lineCode;
    private String lineName;
    
    private String agentCode;
    private String agentName;
        
    private String validStatus;
    private String errorStatus;
    
	private List searchList;

	public Long getRotationNo() {
		return rotationNo;
	}

	public void setRotationNo(Long rotationNo) {
		this.rotationNo = rotationNo;
	}

	public Integer getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(Integer containerNo) {
		this.containerNo = containerNo;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getEtaDate() {
		return etaDate;
	}

	public void setEtaDate(String etaDate) {
		this.etaDate = etaDate;
	}

	public Integer getBolNo() {
		return bolNo;
	}

	public void setBolNo(Integer bolNo) {
		this.bolNo = bolNo;
	}

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	public List getSearchList() {
		return searchList;
	}

	public void setSearchList(List searchList) {
		this.searchList = searchList;
	}
	
	
}
