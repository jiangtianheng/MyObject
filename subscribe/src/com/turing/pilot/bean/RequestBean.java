package com.turing.pilot.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.turing.pilot.util.TuringStringUtil;

public class RequestBean
{

    public TuringPager getPager()
    {
        if (pager == null)
        {
            pager = TuringPager.getPager(paramMap);
        }
        return pager;
    }

    public boolean isSafe()
    {
        return check;
    }

    public void setCheck(boolean check)
    {
        this.check = check;
    }

    public RequestBean(boolean check)
    {
        this.check = check;
    }

    public RequestBean(boolean check, int src)
    {
        this.check = check;
        this.src = src;
    }

    public RequestBean()
    {
    }

    public int getSrc()
    {
        return src;
    }

    public void setSrc(Integer src)
    {
        this.src = src;
    }

    private int                 reqType  = 0;
    private String              ip;
    private int                 src;
    private TuringPager        pager;

    private boolean             check;

    /**
	 * 
	 */
    private Map<String, Object> paramMap = new HashMap<String, Object>();

    public int getReqType()
    {
        return reqType;
    }

    public void setReqType(int reqType)
    {
        this.reqType = reqType;
    }

    public void addParam(String key, Object value)
    {
        if (TuringStringUtil.isBlank(key))
        {
            return;
        }

        if (value instanceof JSONObject)
        {
            Map<String, Object> map = null;
            JSONObject json = (JSONObject) value;
            Set<String> keySet = json.keySet();
            for (String jkey : keySet)
            {
                value = json.get(jkey);
                if (value != null)
                {
                    if (map == null)
                    {
                        map = new HashMap<String, Object>();
                    }
                    map.put(jkey, value);
                }
            }

            if (map != null)
            {
                paramMap.put(key, map);
            }
        }
        else if (value instanceof JSONArray)
        {
            JSONArray jarray = (JSONArray) value;
            if (jarray.size() > 0)
            {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                JSONObject json;
                Map<String, Object> map = null;
                Set<String> keySet;
                for (int i = 0, size = jarray.size(); i < size; i++)
                {
                    json = jarray.getJSONObject(i);
                    keySet = json.keySet();
                    for (String jkey : keySet)
                    {
                        value = json.get(jkey);
                        if (value != null)
                        {
                            if (map == null)
                            {
                                map = new HashMap<String, Object>();
                            }
                            map.put(jkey, value);
                        }
                    }
                    if (map != null)
                    {
                        list.add(map);
                        map = null;
                    }
                }
                paramMap.put(key, list);
                list = null;
            }
        }
        else
        {
            paramMap.put(key, value);
        }
    }

    public String getValue(String key)
    {
        if (key == null)
        {
            return null;
        }
        Object obj = paramMap.get(key);
        if (obj != null)
        {
            return obj.toString();
        }
        return null;
    }
    public	String get2JsonValue(String paraFirName,String paraTwoName){
    	String sReturn="";
    	
    	if (paraFirName == null || paraTwoName==null)
        {
            return null;
        }
    	Object obj = paramMap.get(paraFirName);
    	
        if (obj != null)
        {
        	
        	if (obj instanceof HashMap){
        		Map<String,String> map = (Map<String,String>)obj;
        		return map.get(paraTwoName).toString();
        	}
        	
        	Map<String,String> map = (Map<String,String>)obj;
        	return map.get(paraTwoName).toString();
        	
//        	
//        	for(Iterator<Object> iterator = Object.iterator(); iterator.hasNext();) {  
//        		
//        	}
//        	for(Object objItem:obj){
//        		
//        	}
//        	Object value=obj.
//        	if (value instanceof JSONObject){
//        		
//        	}
//        	Object<HaspMap> objTwo=new Object();
        	
//            return obj.toString();
        }
        return null;
        
    	//return sReturn;
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getValueList(String key)
    {
        if (key == null)
        {
            return null;
        }
        Object obj = paramMap.get(key);
        if (obj != null)
        {
            if (obj instanceof List)
            {
                return (List<Map<String, Object>>) obj;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getValueObject(String key)
    {
        if (key == null)
        {
            return null;
        }
        Object obj = paramMap.get(key);
        if (obj != null)
        {
            if (obj instanceof Map<?, ?>)
            {
                return (Map<String, Object>) obj;
            }
        }
        return null;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String toString()
    {
        if (paramMap != null)
        {
            Set<String> setkey = paramMap.keySet();
            Iterator<String> it = setkey.iterator();
            String key;
            StringBuffer sb = new StringBuffer();
            while (it.hasNext())
            {
                key = it.next();
                if (sb.length() > 0)
                {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(paramMap.get(key));
            }
            return sb.toString();
        }
        return "";
    }
}
