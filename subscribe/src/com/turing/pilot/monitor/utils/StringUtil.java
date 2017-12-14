package com.turing.pilot.monitor.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
    /**
     * 
     * 
     * @param str
     * @param suffix
     * @return
     */
    public static String removeSuffix(String str, String suffix)
            throws Exception
    {
        if (null == str)
            return null;
        if ("".equals(str.trim()))
            return "";

        if (null == suffix || "".equals(suffix))
            return str;

        if (str.endsWith(suffix))
        {
            return str.substring(0, str.length() - suffix.length());
        }

        throw new Exception(str + " 没有按指定字符串" + suffix + "结尾");
    }

    public static boolean isNum(String str){
    	for (int i = str.length();--i>=0;){   
    		if (!Character.isDigit(str.charAt(i))){
    			return false;
    		}
    	}
    	return true;
    }

    /**
     * Check the String is blank or not
     * 
     * @param str
     * @return
     * @throws UtilException
     */
    public static boolean isBlank(String str)
    {
        return null == str || "".equals(str.trim());
    }

    public static boolean isBlank(Long str)
    {
        return null == str;
    }

    /**
     * 将对象转成String
     * 
     * @param obj
     * @return
     */
    public static String toString(Object obj)
    {
        if (obj == null)
        {
            return "";
        }
        return obj.toString().trim();
    }

    /**
     * 
     * @param str
     * @return
     */
    public static String getString(String str)
    {
        if (null == str)
            return "";
        return str;

    }

    /**
     * 计算两个数字字符串的�?
     * 
     * @param augend
     * @param addend
     * @return
     * @throws UtilException
     */
    public static String getSum(String augend, String second, String addend)
    {
        if (augend == null)
            augend = "0";
        if (second == null)
            second = "0";
        if (addend == null)
            addend = "0";
        int sum = Integer.parseInt(augend) + Integer.parseInt(second)
                + Integer.parseInt(addend);
        return new Integer(sum).toString();
    }

    public static String change(String str, int n, boolean isLeft)
    {
        if (str == null || str.length() >= n)
            return str;
        StringBuffer s = new StringBuffer();
        for (int i = str.length(); i < n; i++)
            s.append('0');
        if (isLeft)
            return s.append(str).toString();
        else
            return s.insert(0, str).toString();
    }

    public static String getInString(String str)
    {
        if (str == null)
            return null;
        int len = str.length();
        StringBuffer buf = new StringBuffer(len << 1).append('\'');
        for (int i = 0; i < len; i++)
        {
            char Char = str.charAt(i);
            if (',' == Char)
                buf.append("','");
            else
                buf.append(Char);
        }
        return buf.append('\'').toString();
    }

    /**
     * 根据标识获取str中最后一个flag后的内容
     * 
     * @param str
     * @param flag
     * @return
     */
    public static String getLastStr(String str, String flag)
    {
        if (isBlank(str))
            return null;
        int index = str.lastIndexOf(flag);
        if (index < 0)
        {
            return str;
        }
        else
        {
            return str.substring(index + flag.length());
        }

    }

    /**
     * 获取正则表达式匹配的字符串，�?符处理一下，不然匹配时会认作分组
     * 
     * @param str
     * @return
     */
    public static String getRegexStr(String str)
    {
        String ret = "";
        if (isBlank(str))
            return "";
        if (str.indexOf('$', 0) > -1)
        {
            while (str.length() > 0)
            {
                if (str.indexOf('$', 0) > -1)
                {
                    ret += str.subSequence(0, str.indexOf('$', 0));
                    ret += "\\$";
                    str = str.substring(str.indexOf('$', 0) + 1, str.length());
                }
                else
                {
                    ret += str;
                    str = "";
                }
            }

        }
        else
        {

            ret = str;
        }

        return ret;

    }

    /**
     * 比较两个String对象值是否相�?
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean compareString(String str1, String str2)
    {
        if (null == str1)
        {
            str1 = "";
        }
        if (null == str2)
        {
            str2 = "";
        }
        if (str1.trim().equals(str2.trim()))
        {
            return true;
        }
        return false;
    }

    /**
     * 将name转换成首字母大写
     * 
     * @param name
     * @return
     */
    public static String trunUpName(String name)
    {
        if (StringUtil.isBlank(name))
        {
            return name;
        }
        else
        {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }

    // 去掉前导字符 0 �?空格，至少保留最右边�?��
    public static String ltrim(String inStr)
    {
        StringBuffer sb = new StringBuffer();
        if (inStr == null || inStr.length() == 0)
            return inStr;
        for (int i = 0; i < inStr.length(); i++)
        {
            if ((i == inStr.length() - 1) || inStr.charAt(i) != '0'
                    && inStr.charAt(i) != ' ')
                sb.append(inStr.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 把字符串用特定字符补成固定字节长度的字符�?
     * 
     * @param src
     *            原字符串
     * @param temp
     *            被补的字�?
     * @param sumLength
     *            补充后的字节长度
     * @param direction
     *            补的方向，L：左补，R：右补，默认是左补，忽略大小�?
     * @return
     */
    private static String fillStringByByte(String src, char temp,
            int sumLength, String direction)
    {
        String dest = "";
        src = src != null ? src.trim() : "";
        while (--sumLength >= src.getBytes().length)
        {
            dest += temp;
        }
        return "R".equalsIgnoreCase(direction) ? src + dest : dest + src;
    }

    /**
     * 用特定的字符左补成固定字节长度的字符�?
     * 
     * @param src
     *            原字符串
     * @param temp
     *            被补的字�?
     * @param sumLength
     *            补充后的字节长度
     * @return
     */
    public static String lFillString(String src, char temp, int sumLength)
    {
        return fillStringByByte(src, temp, sumLength, "L");
    }

    /**
     * 用特定的字符右补成固定字节长度的字符�?
     * 
     * @param src
     *            原字符串
     * @param temp
     *            被补的字�?
     * @param sumLength
     *            补充后的字节长度
     * @return
     */
    public static String rFillString(String src, char temp, int sumLength)
    {
        return fillStringByByte(src, temp, sumLength, "R");
    }

    /**
     * 对GBK编码的字符串转换成UTF-8的字符串，并保证不产生乱�? 转换后的UTF-8字符串可以利用new
     * String(UTF-8.getByte(),"GBK")转回gbk
     * 
     * @param gbk
     * @return
     */
    public static String convertGBK2UTF8(String gbk)
    {
        String utf8 = "";
        try
        {
            utf8 = new String(gbk2utf8(gbk), "UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return utf8;
    }

    public static byte[] gbk2utf8(String chenese)
    {
        char c[] = chenese.toCharArray();
        byte[] fullByte = new byte[3 * c.length];
        for (int i = 0; i < c.length; i++)
        {
            int m = (int) c[i];
            String word = Integer.toBinaryString(m);

            StringBuffer sb = new StringBuffer();
            int len = 16 - word.length();
            for (int j = 0; j < len; j++)
            {
                sb.append("0");
            }
            sb.append(word);
            sb.insert(0, "1110");
            sb.insert(8, "10");
            sb.insert(16, "10");

            String s1 = sb.substring(0, 8);
            String s2 = sb.substring(8, 16);
            String s3 = sb.substring(16);

            byte b0 = Integer.valueOf(s1, 2).byteValue();
            byte b1 = Integer.valueOf(s2, 2).byteValue();
            byte b2 = Integer.valueOf(s3, 2).byteValue();
            byte[] bf = new byte[3];
            bf[0] = b0;
            fullByte[i * 3] = bf[0];
            bf[1] = b1;
            fullByte[i * 3 + 1] = bf[1];
            bf[2] = b2;
            fullByte[i * 3 + 2] = bf[2];

        }
        return fullByte;
    }

    public static String replaceBlank(String str)
    {
        String dest = "";
        if (str != null)
        {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        char[] chars = dest.toCharArray();
        StringBuffer buffer = new StringBuffer();
        if (chars != null && chars.length > 0)
        {
            for (int i = 0; i < chars.length; i++)
            {
                if ((int) chars[i] != 160)
                {
                    buffer.append(chars[i]);
                }
            }
            dest = buffer.toString();
        }
        return dest;

    }

    /***
     * Delete empty char
     * 
     * @param inputStr
     * @return
     */
    public static String killspace(String inputStr)
    {
        inputStr = (inputStr == null ? "" : inputStr);
        inputStr = inputStr.trim();
        return inputStr;
    }

    public static String killNull(String inputStr)
    {
        inputStr = (inputStr == null ? "" : inputStr);
        return inputStr;
    }

    public static String substring(String string, int index)
    {
        char[] charArray = string.toCharArray();
        int number = 0;
        String substring = "";
        for (int i = 0, j = 0; i < index && j < string.length();)
        {
            char tempChar = charArray[j];
            if (Character.getType(tempChar) == Character.OTHER_LETTER)
            {
                i = i + 2;
                if (i > index)
                {
                    if (i == (index + 1))
                    {
                        continue;
                    }
                }
            }
            else
            {
                i++;
            }
            j++;
            number++;
        }
        substring = string.substring(0, number);
        return substring;
    }

    public static boolean isValidImsi(String imsi)
    {
        if (imsi != null && imsi.length() > 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //    
    // public static void main(String [] args){
    // System.out.println(NgsteamStringUtil.substring("家园7：贵�?, 7));
    // }
}
