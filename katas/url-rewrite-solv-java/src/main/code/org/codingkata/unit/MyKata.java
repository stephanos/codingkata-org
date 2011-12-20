package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
     public String rewrite(String url) {

        if (url.contains("/article/")) {
            String n = url.replaceAll("/article/", "");
            try {
                Long.parseLong(n);
                return "/article?id=" + n;
            } catch (NumberFormatException e) {
                return url;
            }

        } else if (url.contains("/guide")) {
            String[] parts = url.split("/");
            if (parts[3].equals("2008"))
                return url.replaceAll("2008", "2009");
            else
                return url;

        } else if (url.contains("/company")) {
            String[] parts = url.split("/");
            String ret = "/company?country=" + parts[2];
            if (parts.length > 3)
                ret += "&city=" + parts[3];
            return ret;

        } else {
            return url;
        }
    }
}