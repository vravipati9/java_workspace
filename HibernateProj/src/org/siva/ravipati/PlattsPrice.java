package org.siva.ravipati;


public class PlattsPrice {

	public static final String PROP_PP_PRICE_ID = "PlattsPriceId";
	public static final String PROP_PP_SHEET_ID = "PlattsSheetId";
	public static final String PROP_PP_REGION_TYPE_ID = "RegionTypeId";
	public static final String PROP_PP_LOW = "PriceLow";
	public static final String PROP_PP_HIGH = "PriceHigh";
	public static final String PROP_PP_PLATTS_SHEET = "PlattsSheet";

	private Integer plattsPriceId;
	// private Integer plattsSheetId;
	private Integer regionTypeId;
	// private Date priceDate;
	private Integer priceLow;
	private Integer priceHigh;
	// many to one
	private PlattsSheet plattsSheet;

	public Integer getPlattsPriceId() {
		return this.plattsPriceId;
	}

	public void setPlattsPriceId(Integer plattsPriceId) {
		this.plattsPriceId = plattsPriceId;
	}

	public Integer getRegionTypeId() {
		return this.regionTypeId;
	}

	public void setRegionTypeId(Integer regionTypeId) {
		this.regionTypeId = regionTypeId;
	}

	public Integer getPriceLow() {
		return this.priceLow;
	}

	public void setPriceLow(Integer priceLow) {
		this.priceLow = priceLow;
	}

	public Integer getPriceHigh() {
		return this.priceHigh;
	}

	public void setPriceHigh(Integer priceHigh) {
		this.priceHigh = priceHigh;
	}

	public PlattsSheet getPlattsSheet() {
		return this.plattsSheet;
	}

	public void setPlattsSheet(PlattsSheet plattsSheet) {
		this.plattsSheet = plattsSheet;
	}

}
