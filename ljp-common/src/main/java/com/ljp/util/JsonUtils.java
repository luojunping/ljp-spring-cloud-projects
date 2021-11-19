package com.ljp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

    private static final ObjectMapper OM = new ObjectMapper();

    static {

    }

    private JsonUtils() throws IllegalAccessException {
        throw new IllegalAccessException("JsonUtils is not allow create...");
    }

    public static String objToJsonStr(Object object) {
        try {
            return OM.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // e.printStackTrace();
        }
        return null;
    }

}
