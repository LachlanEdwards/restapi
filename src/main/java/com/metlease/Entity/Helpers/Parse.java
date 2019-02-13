package com.metlease.Entity.Helpers;

import com.metlease.Exceptions.ParseException;

import java.net.URI;
import java.net.URL;

public class Parse {
    public static URL parseUrl(String uri) throws Exception {
        URL url = new URL(uri);
        return new URI(url.getProtocol(), url.getAuthority(), url.getPath(), url.getQuery(), url.getRef()).toURL();
    }

    public static String[] parseName(String name) throws ParseException {
        String[] fl = new String[1];
        int lastIndexOfSpace = name.lastIndexOf(" ");
        if (lastIndexOfSpace > 0) {
            fl[0] = name.substring(0, lastIndexOfSpace);
            fl[1] = name.substring(lastIndexOfSpace + 1, name.length());
            return fl;
        } else {
            throw new ParseException("Could not parse format.");
        }
    }
}
