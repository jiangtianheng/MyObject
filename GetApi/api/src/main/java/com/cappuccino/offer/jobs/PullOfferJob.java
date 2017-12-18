package com.cappuccino.offer.jobs;

import java.rmi.server.ExportException;

import org.apache.log4j.Logger;

import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.offers.cpi.v1.PullOfferV1;

public class PullOfferJob
{

    private static Logger logger = Logger.getLogger(PullOfferJob.class);
   

    /**
     * 第几套回调
     */
    private Integer version;
    /**
     * 系统
     */
    private String os;

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    /**
     * 拉取offer
     */
    public void updateOffers()
    {
        try
        {
            if (os == null)
                throw new ExportException("os not null.");
            if (os.equals("cpi"))
            {
                PullCpiOffers();// android
            }
            else
            {
                throw new ExportException("can not find os.");
            }
        }
        catch (Exception e)
        {
            logger.error("error", e);
        }
    }

    /**
     * 拉取android类型的offer
     */
    public void PullCpiOffers()
    {
        try
        {
            if (version == null)
                throw new ExportException("version not null.");
            if (version.intValue() == GlobalConst.OFFER_VERSION_1)
            {
                PullOfferV1 v1 = new PullOfferV1();
                v1.updateOffers();
            }
            else if (version.intValue() == GlobalConst.OFFER_VERSION_2)
            {
                // PullOfferV2 v2 = new PullOfferV2();
                // v2.updateOffers();
            }
            else if (version.intValue() == GlobalConst.OFFER_VERSION_3)
            {
                // PullOfferV3 v3 = new PullOfferV3();
                // v3.updateOffers();
            }
            else
            {
                throw new ExportException("can not find version.");
            }
        }
        catch (Exception e)
        {
            logger.error(e);
        }
    }

}
