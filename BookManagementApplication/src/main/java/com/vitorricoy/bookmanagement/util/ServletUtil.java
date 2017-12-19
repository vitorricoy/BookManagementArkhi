package com.vitorricoy.bookmanagement.util;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 * Class with tools for the servlets
 * @author vitor
 */
public class ServletUtil {
    
    /**
     * Get the json of a HttpServletRequest
     * @param request The request object
     * @return The Json received in the request
     * @throws IOException
     */
    public static String getJson(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        return sb.toString();
    }
    
}
