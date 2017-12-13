package com.cappuccino.offer.domain.ad;

import java.util.Date;

public class Provider
{
    private Long id;

    private String name;

    private Integer template;

    private String apiUrl;

    private String clickParams;

    private String callbackDomain;

    private Integer maxCap;

    private Integer maxClick;

    private Long maxPayout;

    private Byte status;

    private Date createdate;

    private Date updatedate;

    private String remarks;

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

    public Integer getTemplate()
    {
        return template;
    }

    public void setTemplate(Integer template)
    {
        this.template = template;
    }

    public String getApiUrl()
    {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl)
    {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    public String getClickParams()
    {
        return clickParams;
    }

    public void setClickParams(String clickParams)
    {
        this.clickParams = clickParams == null ? null : clickParams.trim();
    }

    public String getCallbackDomain()
    {
        return callbackDomain;
    }

    public void setCallbackDomain(String callbackDomain)
    {
        this.callbackDomain = callbackDomain == null ? null : callbackDomain
                .trim();
    }

    public Integer getMaxCap()
    {
        return maxCap;
    }

    public void setMaxCap(Integer maxCap)
    {
        this.maxCap = maxCap;
    }

    public Integer getMaxClick()
    {
        return maxClick;
    }

    public void setMaxClick(Integer maxClick)
    {
        this.maxClick = maxClick;
    }

    public Long getMaxPayout()
    {
        return maxPayout;
    }

    public void setMaxPayout(Long maxPayout)
    {
        this.maxPayout = maxPayout;
    }

    public Byte getStatus()
    {
        return status;
    }

    public void setStatus(Byte status)
    {
        this.status = status;
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

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}