package zpm.lib.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Build;
import android.util.Patterns;

/**
 * 字符串操作工具
 */
public class StringUtils {
    /**
     * is null or its length is 0 or it is made by space
     * 
     * <pre>
     * isBlank(null) = true;
     * isBlank(&quot;&quot;) = true;
     * isBlank(&quot;  &quot;) = true;
     * isBlank(&quot;a&quot;) = false;
     * isBlank(&quot;a &quot;) = false;
     * isBlank(&quot; a&quot;) = false;
     * isBlank(&quot;a b&quot;) = false;
     * </pre>
     * 
     * @param str
     * @return if string is null or its size is 0 or it is made by space, return
     *         true, else return false.
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * @param str
     * @return if string is null or its size is 0 or it is made by space, return
     *         false, else return true.
     */
    public static boolean isNotBlank(String str) {
        return (str != null && str.trim().length() > 0);
    }

    /**
     * is null or its length is 0
     * 
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     * 
     * @param str
     * @return if string is null or its size is 0, return true, else return
     *         false.
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * compare two string
     * 
     * <pre>
     * isEquals(null, null) = true;
     * isEquals(null, &quot;abc&quot;) = false;
     * isEquals(&quot;abc&quot;, null) = false;
     * </pre>
     * 
     * @param actual
     * @param expected
     * @return
     * @see ObjectUtils#isEquals(Object, Object)
     */
    public static boolean isEquals(String actual, String expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }

    /**
     * null string to empty string
     * 
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     * 
     * @param str
     * @return
     */
    public static String nullStrToEmpty(String str) {
        return (str == null ? "" : str);
    }

    /**
     * capitalize first letter
     * 
     * <pre>
     * capitalizeFirstLetter(null)     =   null;
     * capitalizeFirstLetter("")       =   "";
     * capitalizeFirstLetter("2ab")    =   "2ab"
     * capitalizeFirstLetter("a")      =   "A"
     * capitalizeFirstLetter("ab")     =   "Ab"
     * capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     * 
     * @param str
     * @return
     */
    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str : new StringBuilder(str.length())
                .append(Character.toUpperCase(c)).append(str.substring(1)).toString();
    }

    /**
     * encoded in utf-8
     * 
     * <pre>
     * utf8Encode(null)        =   null
     * utf8Encode("")          =   "";
     * utf8Encode("aa")        =   "aa";
     * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
     * </pre>
     * 
     * @param str
     * @return
     * @throws UnsupportedEncodingException if an error occurs
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    /**
     * encoded in utf-8, if exception, return defultReturn
     * 
     * @param str
     * @param defultReturn
     * @return
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }

    /**
     * get innerHtml from href
     * 
     * <pre>
     * getHrefInnerHtml(null)                                  = ""
     * getHrefInnerHtml("")                                    = ""
     * getHrefInnerHtml("mp3")                                 = "mp3";
     * getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
     * getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
     * getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
     * getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
     * getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
     * </pre>
     * 
     * @param href
     * @return <ul>
     *         <li>if href is null, return ""</li>
     *         <li>if not match regx, return source</li>
     *         <li>return the last string that match regx</li>
     *         </ul>
     */
    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }

        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg, Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }

/**
     * process special char in html
     * 
     * <pre>
     * htmlEscapeCharsToString(null) = null;
     * htmlEscapeCharsToString("") = "";
     * htmlEscapeCharsToString("mp3") = "mp3";
     * htmlEscapeCharsToString("mp3&lt;") = "mp3<";
     * htmlEscapeCharsToString("mp3&gt;") = "mp3\>";
     * htmlEscapeCharsToString("mp3&amp;mp4") = "mp3&mp4";
     * htmlEscapeCharsToString("mp3&quot;mp4") = "mp3\"mp4";
     * htmlEscapeCharsToString("mp3&lt;&gt;&amp;&quot;mp4") = "mp3\<\>&\"mp4";
     * </pre>
     * 
     * @param source
     * @return
     */
    public static String htmlEscapeCharsToString(String source) {
        return StringUtils.isEmpty(source) ? source : source.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
                .replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    /**
     * transform half width char to full width char
     * 
     * <pre>
     * fullWidthToHalfWidth(null) = null;
     * fullWidthToHalfWidth("") = "";
     * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
     * fullWidthToHalfWidth("！＂＃＄％＆) = "!\"#$%&";
     * </pre>
     * 
     * @param s
     * @return
     */
    public static String fullWidthToHalfWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 12288) {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            } else if (source[i] >= 65281 && source[i] <= 65374) {
                source[i] = (char) (source[i] - 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * transform full width char to half width char
     * 
     * <pre>
     * halfWidthToFullWidth(null) = null;
     * halfWidthToFullWidth("") = "";
     * halfWidthToFullWidth(" ") = new String(new char[] {12288});
     * halfWidthToFullWidth("!\"#$%&) = "！＂＃＄％＆";
     * </pre>
     * 
     * @param s
     * @return
     */
    public static String halfWidthToFullWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                source[i] = (char) 12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            } else if (source[i] >= 33 && source[i] <= 126) {
                source[i] = (char) (source[i] + 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * 是否是数字
     * 
     * @author xiangyutian
     * @param num
     * @return create at 2014-4-21 下午5:11:01
     */
    public static boolean isNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是电话号码
     * 
     * @author kimwang
     * @param phoneNum
     * @return create at 2014-4-29
     */
    public static boolean checkCellPhone(String phoneNum) {
        String check = "^(1[0-9])\\d{9}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phoneNum);
        return matcher.matches();
    }

    /**
     * 是否是字母，数字，中文
     * 
     * @param string
     * @return
     */
    public static boolean checkNickNameIsAlphFigureChinese(String string) {
        String check = "[0-9a-zA-Z\u4e00-\u9fa5]*";
        Pattern regex = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(string);
        return matcher.matches();
    }

    /**
     * 是否已weibo|官方|微博开头
     * 
     * @param string
     * @return
     */
    public static boolean checkNickNameIsStartByStr(String string) {
        String check = "^[weibo|官方|微博](.)*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(string);
        return matcher.matches();
    }

    /**
     * 是否包含搜狐|搜狐微博|sohu|souhu
     * 
     * @param string
     * @return
     */
    public static boolean checkNickNameIsContains(String string) {
        String check = "搜狐|搜狐微博|sohu|souhu";
        Pattern regex = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(string);
        return matcher.find();
    }

    /**
     * 去除空格
     * 
     * @author xiangyutian
     * @param str
     * @return create at 2014-5-6 下午2:16:42
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 首字母是否为小写英文字母
     * 
     * @param content
     * @return
     */
    public static boolean checkFirstCharLower(String content) {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        String check = "[a-z](.)*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(content);
        return matcher.matches();
    }

    /**
     * 是否符合email格式
     * 
     * @param email
     * @return
     */
    public static boolean checkEmailUserName(String email) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } else {
            // This regex is really slow.
            // TODO: remove this branch after updating minSDKVersion to 8.
            String check = "^([a-z0-9A-Z-_]+[-|_|\\.]?)+[a-z0-9A-Z_-]@([a-z0-9A-Z_+]+(-[a-z0-9A-Z_+]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            return matcher.matches();
        }
    }

    public static boolean checkStringIsForbid(String string) {
        String check = "(Abuse|contact|help|info|jobs|owner|sales|staff|sales|support|www)?+(@sohu.com)";
        Pattern regex = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(string);
        return matcher.matches();
    }

    public static boolean checkStringIsContains(String string) {
        String check = "admin|master";
        Pattern regex = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(string);
        return matcher.find();
    }

    public static boolean checkPassportIsValid(String str) {
        if (checkEmailUserName(str)) {
            if (checkStringIsContains(str)) {
                return false;
            }
            if (checkStringIsForbid(str)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkPasswordIsValid(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }

        String check = "[0-9a-zA-Z~!@#$%^&*()\\-+_={}\\[\\];:'\",.<>?/]*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(string);
        return matcher.matches();
    }

    public static int stringToInt(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        int ret = 0;
        try {
            ret = Integer.parseInt(str);
        } catch (Exception e) {

        }
        return ret;
    }
}