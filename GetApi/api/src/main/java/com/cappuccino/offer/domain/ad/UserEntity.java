package com.cappuccino.offer.domain.ad;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String reallyName;

    private String email;

    private Integer status;

    private Integer role;

    private String apikey;

    private Date createdate;

    private Date updatedate;

    private String ext;

   

  

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getReallyName()
    {
        return reallyName;
    }

    public void setReallyName(String reallyName)
    {
        this.reallyName = reallyName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getRole()
    {
        return role;
    }

    public void setRole(Integer role)
    {
        this.role = role;
    }

    public String getApikey()
    {
        return apikey;
    }

    public void setApikey(String apikey)
    {
        this.apikey = apikey;
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

    public String getExt()
    {
        return ext;
    }

    public void setExt(String ext)
    {
        this.ext = ext;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

}
