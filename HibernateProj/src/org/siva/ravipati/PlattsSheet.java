package org.siva.ravipati;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


public class PlattsSheet {

	public static final String PROP_PS_PLATTSSHEET_ID = "PlattsSheetId";
	public static final String PROP_PS_PLATTSSHEET_NAME = "PlattsSheetName";
	public static final String PROP_PS_STATUS_TYPE_ID = "StatusTypeId";
	public static final String PROP_PS_EFFDATE = "EffectiveDate";

	// one to many RelationShip for PlattsSheet to PlattsPrice &
	// PlattsSheet to PlattsAuditPrice
	private Set<PlattsPrice> plattsPrices = new LinkedHashSet<PlattsPrice>();
	private Integer plattsSheetId;
	private String plattsSheetName;
	private String statusTypeId;
	public void setStatusTypeId(String statusTypeId) {
		this.statusTypeId = statusTypeId;
	}
	public String getStatusTypeId() {
		return this.statusTypeId;
	}
	private Date effectiveDate;

	public void addToPrice(PlattsPrice plattsPrice)
	{
		plattsPrice.setPlattsSheet(this);
		this.plattsPrices.add(plattsPrice);
	}

	/**
	 * 
	 * @param plattsPrice
	 *            is the PlattsPrice to be removed from Collection
	 */
	public void removeFromPrice(PlattsPrice plattsPrice)
	{
		plattsPrice.setPlattsSheet(null);
		this.plattsPrices.remove(plattsPrice);
	}

	public Integer getPlattsSheetId() {
		return this.plattsSheetId;
	}
	public void setPlattsSheetId(Integer plattsSheetId) {
		this.plattsSheetId = plattsSheetId;
	}
	public String getPlattsSheetName() {
		return this.plattsSheetName;
	}
	public void setPlattsSheetName(String plattsSheetName) {
		this.plattsSheetName = plattsSheetName;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Set<PlattsPrice> getPlattsPrices() {
		return this.plattsPrices;
	}
	public void setPlattsPrices(Set<PlattsPrice> plattsPrices) {
		this.plattsPrices = plattsPrices;
	}
	@Override
	public String toString() {
		System.out.println("plattsSheetId	:"+plattsSheetId+"	"+
						   "plattsSheetName :"+plattsSheetName);
		return super.toString();
		
	}
}
