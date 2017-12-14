package com.cappuccino.offer.offers.cpi.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.cappuccino.offer.dao.AdsTemDAO;
import com.cappuccino.offer.dao.ProviderDAO;
import com.cappuccino.offer.domain.GlobalConst;
import com.cappuccino.offer.domain.ad.Provider;
import com.cappuccino.offer.jobs.JobExecutorService;
import com.cappuccino.offer.util.SpringHelper;

public class PullOfferV1
{

    private Logger logger = Logger.getLogger(PullOfferV1.class);

    private JobExecutorService jobExecutorService = JobExecutorService
            .getInstance();

    public void updateOffers()
    {
        logger.info("update offer start.....");
        List<Future<Boolean>> tasks = new ArrayList<Future<Boolean>>();
        
        //清空临时表数据
        AdsTemDAO adsTemDAO = SpringHelper.getBean("adsTemDAO",
                AdsTemDAO.class);
        adsTemDAO.delAll();
        
        /**
         * 模板写入数据
         */
        ProviderDAO ProviderDao = SpringHelper.getBean("providerDAO",
                ProviderDAO.class);
        List<Provider> providerList = ProviderDao.getListAll();
        for (Provider entity : providerList)
        {
            if (entity.getTemplate() == GlobalConst.avazu_template)
            {
                System.out.println("====");
                AvazuTemplate AvazuTemplate = new AvazuTemplate(
                        GlobalConst.CALL_WORK, entity);
                tasks.add(jobExecutorService.submitTask(AvazuTemplate));
            }
        }

        for (Future<Boolean> f : tasks)
        {
            try
            {
                f.get();
            }
            catch (Exception e)
            {
                logger.error(e);
            }
        }
        logger.info("update offer into tem  end.....");
    }
}