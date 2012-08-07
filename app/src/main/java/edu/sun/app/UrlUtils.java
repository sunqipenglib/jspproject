package edu.sun.app;

import org.apache.commons.lang3.StringUtils;

/**
 * User: sunqipeng
 * Date: 12-8-7
 */
public class UrlUtils {
    /**
     * @param value
     * @return
     */
    public static String getBasePath(String value) {
        String[] fragment = StringUtils.split(value, "/");
        return fragment[0] + "://" + fragment[1];
    }

    /**
     * @param parentUrl
     * @param url
     * @return
     */
    public static String buildPath(String parentUrl, String url) {
        if (StringUtils.startsWith(url, "http")) {
            return url;
        }
        if (StringUtils.startsWith(url, "/")) {
            return getBasePath(parentUrl) + url;
        }

        String basePath = StringUtils.substringBeforeLast(parentUrl, "/");
        return basePath + "/" + url;
    }

    public static boolean isValidUrl(String url) {
        if (StringUtils.startsWith(url, "#"))
            return false;

        if (StringUtils.endsWithIgnoreCase(url, "jpg"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "jpeg"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "bmp"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "png"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "pdf"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "mp3"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "mp4"))
            return false;
        if (StringUtils.endsWithIgnoreCase(url, "jpeg"))
            return false;
        return true;

    }
}
