package com.robl2e.codepathipcassignment7.util;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;

/**
 * Created by robl2e on 2/10/18.
 */

public class JsonUtils {
    public static  <T> T fromJson(String json, Class<T> tClass) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, tClass);
    }
}
