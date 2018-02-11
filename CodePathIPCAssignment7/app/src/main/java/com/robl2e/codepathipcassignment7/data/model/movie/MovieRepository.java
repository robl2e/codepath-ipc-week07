package com.robl2e.codepathipcassignment7.data.model.movie;

import com.robl2e.codepathipcassignment7.data.remote.AppResponseHandler;
import com.robl2e.codepathipcassignment7.data.remote.movie.MovieDBApiClient;

/**
 * Created by robl2e on 2/10/18.
 */

public class MovieRepository {
    public void getMoviesNowPlaying(AppResponseHandler appResponseHandler) {
        MovieDBApiClient.getInstance().getMoviesNowPlaying(appResponseHandler);
    }
}
