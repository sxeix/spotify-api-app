package com.sxeix.genrecalculator.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringUtil {

    public static String getIdFromURI(String uri) {
        return uri.replace("spotify:artist:", "");
    }
}
