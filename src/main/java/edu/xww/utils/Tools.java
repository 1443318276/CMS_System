package edu.xww.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    private static final String MODAL = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
    private static final Pattern humpPattern = Pattern.compile("[A-Z]");
    private static final Random random = new Random();

    public static String randomStr(int length) {
        return randomStr(length, MODAL);
    }

    public static String randomStr(int length, String strBase) {
        if (StringUtils.isEmpty(strBase) || length < 1) return "";
        int strLength = strBase.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            builder.append(strBase.charAt(random.nextInt(strLength)));
        }
        return builder.toString();
    }

    public static String md5(String baseStr) {
        baseStr = baseStr == null ? "" : baseStr;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(baseStr.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToHex(byte[] md5Array) {
        StringBuilder builder = new StringBuilder();
        for (byte temp : md5Array) {
            String hexString = Integer.toHexString(0xff & temp);
            if (hexString.length() == 1) {
                builder.append("0");
            }
            builder.append(hexString);
        }
        return builder.toString();
    }

    /**
     * 驼峰 转化 下划线
     * @param str 待转换的字符串
     * @return 转换后的字符串，如果原始字符串为空则返回NULL
     */
    public static String humpToLine(String str) {
        if (StringUtils.isEmpty(str)) return null;
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public static String cookieValue(HttpServletRequest request, String cookieName) {
        if (StringUtils.isEmpty(cookieName) || request == null) return null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
