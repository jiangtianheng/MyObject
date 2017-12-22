package com.cappuccino.offer.jobs;

import com.cappuccino.offer.domain.ad.AdsTem;

public class AditemJob
{
    public AdsTem InsertAdsTem(String name, Integer providerId, String pkg,
            String offerid, String countries, Integer os, Double revenue,
            int payoutType, String tracklink, String previewlink, String icon,
            String creativeFiles, int incentive, int osMinVersion,
            String carriers, Integer cap, String description)
    {
        AdsTem aditem = new AdsTem();
        aditem.setName(name);
        aditem.setProviderId(providerId);
        aditem.setPkg(pkg);
        aditem.setOfferId(offerid);
        aditem.setOs(os);
        aditem.setCountries(countries);
        aditem.setRevenue(revenue);
        aditem.setPayoutType(payoutType);
        aditem.setTracklink(tracklink);
        aditem.setPreviewlink(previewlink);
        aditem.setIcon(icon);
        aditem.setCreativeFiles(creativeFiles);
        aditem.setIncentive(incentive);
        aditem.setOsMinVersion(osMinVersion);
        aditem.setCarriers(carriers);
        aditem.setCap(cap);
        aditem.setStatus(0);
        aditem.setDescription(description);
        return aditem;
    }
}
