package com.cappuccino.offer.dao.cache;

import java.util.List;

import com.cappuccino.offer.dao.AdsTemDAO;
import com.cappuccino.offer.domain.ad.AdsTem;


public class CacheAdsTemDAO extends AdsTemDAO
{


    @Override
    public int insert_tem(AdsTem item)
    {
        return super.insert_tem(item);
    }

    @Override
    public void insertBatch_tem(List<AdsTem> adTems)
    {
        super.insertBatch_tem(adTems);
    }

    @Override
    public List<AdsTem> findAffliateByProvider()
    {
        return super.findAffliateByProvider();
    }

    @Override
    public List<AdsTem> findProviders()
    {
        return super.findProviders();
    }

    @Override
    public void delAll()
    {
        super.delAll();
    }

    @Override
    public void deleteByName(String name)
    {
        super.deleteByName(name);

    }

}
