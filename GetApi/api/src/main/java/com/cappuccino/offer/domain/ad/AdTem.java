package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class AdTem implements Serializable {

	private Long id;
	private String name;
	private String country;
	private Double payout;
	private String carrier;
	private Integer os;
	private String tracklink;
	private String previewlink;
	private String offerid;
	private String pkg;
	private Integer type;
	private Integer network;
	private String icon;
	private String traffic;
	private Integer conversion_flow;
	private Integer status;
	private Integer incentive;
	private Date createdate;
	private Date updatedate;
	private Integer cap;
	private String provider;
	private Integer category;
	private Integer isIframe;
	private Integer offer_type;
	private Integer auto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getPayout() {
		return payout;
	}

	public void setPayout(Double payout) {
		this.payout = payout;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Integer getOs() {
		return os;
	}

	public void setOs(Integer os) {
		this.os = os;
	}

	public String getTracklink() {
		return tracklink;
	}

	public void setTracklink(String tracklink) {
		this.tracklink = tracklink;
	}

	public String getPreviewlink() {
		return previewlink;
	}

	public void setPreviewlink(String previewlink) {
		this.previewlink = previewlink;
	}

	public String getOfferid() {
		return offerid;
	}

	public void setOfferid(String offerid) {
		this.offerid = offerid;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNetwork() {
		return network;
	}

	public void setNetwork(Integer network) {
		this.network = network;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public Integer getConversion_flow() {
		return conversion_flow;
	}

	public void setConversion_flow(Integer conversion_flow) {
		this.conversion_flow = conversion_flow;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIncentive() {
		return incentive;
	}

	public void setIncentive(Integer incentive) {
		this.incentive = incentive;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getIsIframe() {
		return isIframe;
	}

	public void setIsIframe(Integer isIframe) {
		this.isIframe = isIframe;
	}

	public Integer getOffer_type() {
		return offer_type;
	}

	public void setOffer_type(Integer offer_type) {
		this.offer_type = offer_type;
	}

	public Integer getAuto() {
		return auto;
	}

	public void setAuto(Integer auto) {
		this.auto = auto;
	}

}
