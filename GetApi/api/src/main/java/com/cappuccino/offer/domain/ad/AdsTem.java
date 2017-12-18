package com.cappuccino.offer.domain.ad;

import java.util.Date;

public class AdsTem
{
    private Long id;
    private String name;
    private Integer providerId;
    private String pkg;
    private String offerId;
    private Double payout;
    private Integer payoutType;
    private String tracklink;
    private String previewlink;
    private String countries;
    private Integer os;
    private String icon;
    private String creativeFiles;
    private Integer incentive;
    private Integer osMinVersion;
    private String carriers;
    private Integer cap;
    private Integer status;
    private String description;
    private Date createdate;
    private Date updatedate;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public Integer getProviderId()
    {
        return providerId;
    }

    public void setProviderId(Integer providerId)
    {
        this.providerId = providerId;
    }

    public String getPkg()
    {
        return pkg;
    }

    public void setPkg(String pkg)
    {
        this.pkg = pkg == null ? null : pkg.trim();
    }

    public String getOfferId()
    {
        return offerId;
    }

    public void setOfferId(String offerId)
    {
        this.offerId = offerId;
    }

    public Double getPayout()
    {
        return payout;
    }

    public void setPayout(Double payout)
    {
        this.payout = payout;
    }

    public Integer getPayoutType()
    {
        return payoutType;
    }

    public void setPayoutType(Integer payoutType)
    {
        this.payoutType = payoutType;
    }

    public String getTracklink()
    {
        return tracklink;
    }

    public void setTracklink(String tracklink)
    {
        this.tracklink = tracklink == null ? null : tracklink.trim();
    }

    public String getPreviewlink()
    {
        return previewlink;
    }

    public void setPreviewlink(String previewlink)
    {
        this.previewlink = previewlink == null ? null : previewlink.trim();
    }

    public String getCountries()
    {
        return countries;
    }

    public void setCountries(String countries)
    {
        this.countries = countries == null ? null : countries.trim();
    }

    public Integer getOs()
    {
        return os;
    }

    public void setOs(Integer os)
    {
        this.os = os;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getCreativeFiles()
    {
        return creativeFiles;
    }

    public void setCreativeFiles(String creativeFiles)
    {
        this.creativeFiles = creativeFiles == null ? null : creativeFiles
                .trim();
    }

    public Integer getIncentive()
    {
        return incentive;
    }

    public void setIncentive(Integer incentive)
    {
        this.incentive = incentive;
    }

    public Integer getOsMinVersion()
    {
        return osMinVersion;
    }

    public void setOsMinVersion(Integer osMinVersion)
    {
        this.osMinVersion = osMinVersion;
    }

    public String getCarriers()
    {
        return carriers;
    }

    public void setCarriers(String carriers)
    {
        this.carriers = carriers == null ? null : carriers.trim();
    }

    public Integer getCap()
    {
        return cap;
    }

    public void setCap(Integer cap)
    {
        this.cap = cap;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreatedate()
    {
        return createdate;
    }

    public void setCreatedate(Date createdate)
    {
        this.createdate = createdate;
    }

    public Date getUpdatedate()
    {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate)
    {
        this.updatedate = updatedate;
    }

}