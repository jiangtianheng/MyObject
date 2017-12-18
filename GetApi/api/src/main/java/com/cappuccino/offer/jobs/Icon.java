package com.cappuccino.offer.jobs;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cappuccino.offer.domain.GlobalConst;

public class Icon
{
    private static String icon;

    public static String getIcon(String os, String url)
    {
        try
        {
            Document doc = Jsoup
                    .connect(url)
                    .header("User-Agent",
                            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                    .get();
            if (os.contains("IOS"))
            {
                Element el_ios = doc.getElementById("left-stack");
                Elements ElArtwork = el_ios.getElementsByClass("artwork");
                String artwork = ElArtwork.get(0) + "";
                icon = artwork.substring(
                        artwork.indexOf("src-swap-high-dpi=") + 19,
                        artwork.indexOf(".jpg") + 4);
            }
            else if (os.contains("ANDROID"))
            {
                Elements el = doc.getElementsByClass("cover-image");
                if (el != null)
                {
                    icon = "https://" + el.get(0).attr("src");
                }
            }

        }
        catch (IOException e)
        {
            icon = "404";
        }

        if (icon == null)
        {
            icon = GlobalConst.icon;
        }
        return icon;
    }
}
