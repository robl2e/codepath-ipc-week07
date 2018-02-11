package com.robl2e.codepathipcassignment7.data.remote.movie;

import com.robl2e.codepathipcassignment7.data.remote.AppResponseHandler;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by robl2e on 2/10/18.
 */

public class MovieDBApiClient {
    private static MovieDBApiClient movieDBClient;

    public static synchronized MovieDBApiClient getInstance() {
        if (movieDBClient == null) {
            movieDBClient = new MovieDBApiClient();
        }
        return movieDBClient;
    }

    // Example query
    // https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String PARAM_API_KEY = "api_key";
    private static final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    private static final String API_NOW_PLAYING = BASE_URL + "/movie/now_playing";

    // Example image
    // http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
    private static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/";

    public void getMoviesNowPlaying(AppResponseHandler responseHandler) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_NOW_PLAYING)
                .newBuilder();
        urlBuilder.addQueryParameter(PARAM_API_KEY, API_KEY);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(responseHandler);
    }

    public static String getImageUrl(String imageUrl) {
        return BASE_IMAGE_URL + imageUrl;
    }
}
