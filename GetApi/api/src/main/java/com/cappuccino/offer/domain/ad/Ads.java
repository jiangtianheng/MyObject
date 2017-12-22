package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class Ads implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer providerId;
    private String pkg;
    private String offerId;
    private Double revenue;
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
    private Integer auto;
    private Integer payout_rate;
    private Integer back_rate;
    private Double payout;
    private Integer daily_cap;
    private Integer click;
    private Integer postback;

    @Override
    public String toString()
    {
        return "Ads [id=" + id + ", name=" + name + ", providerId="
                + providerId + ", pkg=" + pkg + ", offerId=" + offerId
                + ", revenue=" + revenue + ", payoutType=" + payoutType
                + ", tracklink=" + tracklink + ", previewlink=" + previewlink
                + ", countries=" + countries + ", os=" + os + ", icon=" + icon
                + ", creativeFiles=" + creativeFiles + ", incentive="
                + incentive + ", osMinVersion=" + osMinVersion + ", carriers="
                + carriers + ", cap=" + cap + ", status=" + status
                + ", description=" + description + ", createdate=" + createdate
                + ", updatedate=" + updatedate + ", auto=" + auto
                + ", payout_rate=" + payout_rate + ", back_rate=" + back_rate
                + ", payout=" + payout + ", daily_cap=" + daily_cap
                + ", click=" + click + ", postback=" + postback + "]";
    }

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
        this.name = name;
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
        this.pkg = pkg;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public void setOfferId(String offerId)
    {
        this.offerId = offerId;
    }

    public Double getRevenue()
    {
        return revenue;
    }

    public void setRevenue(Double revenue)
    {
        this.revenue = revenue;
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
        this.tracklink = tracklink;
    }

    public String getPreviewlink()
    {
        return previewlink;
    }

    public void setPreviewlink(String previewlink)
    {
        this.previewlink = previewlink;
    }

    public String getCountries()
    {
        return countries;
    }

    public void setCountries(String countries)
    {
        this.countries = countries;
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
        this.icon = icon;
    }

    public String getCreativeFiles()
    {
        return creativeFiles;
    }

    public void setCreativeFiles(String creativeFiles)
    {
        this.creativeFiles = creativeFiles;
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
        this.carriers = carriers;
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

    public Integer getAuto()
    {
        return auto;
    }

    public void setAuto(Integer auto)
    {
        this.auto = auto;
    }

    public Integer getPayout_rate()
    {
        return payout_rate;
    }

    public void setPayout_rate(Integer payout_rate)
    {
        this.payout_rate = payout_rate;
    }

    public Integer getBack_rate()
    {
        return back_rate;
    }

    public void setBack_rate(Integer back_rate)
    {
        this.back_rate = back_rate;
    }

    public Double getPayout()
    {
        return payout;
    }

    public void setPayout(Double payout)
    {
        this.payout = payout;
    }

    public Integer getDaily_cap()
    {
        return daily_cap;
    }

    public void setDaily_cap(Integer daily_cap)
    {
        this.daily_cap = daily_cap;
    }

    public Integer getClick()
    {
        return click;
    }

    public void setClick(Integer click)
    {
        this.click = click;
    }

    public Integer getPostback()
    {
        return postback;
    }

    public void setPostback(Integer postback)
    {
        this.postback = postback;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
}