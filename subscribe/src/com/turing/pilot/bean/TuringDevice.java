package com.turing.pilot.bean;

import java.io.Serializable;
import java.util.Date;

public class TuringDevice implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 2308090241653271900L;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDevid()
    {
        return devid;
    }

    public void setDevid(String devid)
    {
        this.devid = devid;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getMcc()
    {
        return mcc;
    }

    public void setMcc(String mcc)
    {
        this.mcc = mcc;
    }

    public String getMnc()
    {
        return mnc;
    }

    public void setMnc(String mnc)
    {
        this.mnc = mnc;
    }

    public String getImsi()
    {
        return imsi;
    }

    public void setImsi(String imsi)
    {
        this.imsi = imsi;
    }

    public String getImei()
    {
        return imei;
    }

    public void setImei(String imei)
    {
        this.imei = imei;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getAndroid_id()
    {
        return android_id;
    }

    public void setAndroid_id(String androidId)
    {
        android_id = androidId;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Integer getNetwork()
    {
        return network;
    }

    public void setNetwork(Integer network)
    {
        this.network = network;
    }

    public Integer getRoot()
    {
        return root;
    }

    public void setRoot(Integer root)
    {
        this.root = root;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getCpu()
    {
        return cpu;
    }

    public void setCpu(String cpu)
    {
        this.cpu = cpu;
    }

    public String getOs_ver()
    {
        return os_ver;
    }

    public void setOs_ver(String osVer)
    {
        os_ver = osVer;
    }

    public String getResolution()
    {
        return resolution;
    }

    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    public String getAppid()
    {
        return appid;
    }

    public void setAppid(String appid)
    {
        this.appid = appid;
    }

    public String getPkg()
    {
        return pkg;
    }

    public void setPkg(String pkg)
    {
        this.pkg = pkg;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
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

    private Long    id;
    private String  devid;
    private String  channel;
    private String  mcc;
    private String  mnc;
    private String  imsi;
    private String  imei;
    private String  mac;
    private String  android_id;
    private String  language;
    private String  country;
    private Integer network;
    private Integer root;
    private String  model;
    private String  cpu;
    private String  os_ver;
    private String  resolution;
    private String  appid;
    private String  pkg;
    private String  sign;
    private String  ip;
    private Integer status;
    private Date    createdate;
    private Date    updatedate;

}
