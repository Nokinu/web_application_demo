package com.czhang.web_application_demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Utils class to get the IP address
 */
public class IPUtils {

    private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);

    public static String getIpAddress() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String ipAddress = null;
        try {
            ipAddress = httpServletRequest.getHeader("x-forward-for");
            if (!StringUtils.hasText(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getHeader("Proxy-Client-IP");
            }
            if (!StringUtils.hasText(ipAddress) || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getHeader("WL-Proxy-Client-IP");
            }
            if (!StringUtils.hasText(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getHeader("HTTP_CLIENT_IP");
            }
            if (!StringUtils.hasText(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (!StringUtils.hasText(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = httpServletRequest.getRemoteAddr();
            }
        } catch (Exception ex) {
            logger.error("IP Utils exception : ", ex);
        }
        return ipAddress;
    }
}
