package com.robl2e.codepathipcassignment7.ui.movielist;

import android.support.annotation.NonNull;

import com.robl2e.codepathipcassignment7.data.model.movie.Movie;
import com.robl2e.codepathipcassignment7.data.remote.movie.MovieDBApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robl2e on 2/10/18.
 */

public class MovieListItemViewModel {
    private String name;
    private String imageUrl;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public static MovieListItemViewModel convert(Movie from) {
        MovieListItemViewModel viewModel = new MovieListItemViewModel();
        viewModel.setName(from.getTitle());
        viewModel.setDescription(from.getOverview());

        //TODO: Refactor this logic out
        String fullImageUrl = MovieDBApiClient.getImageUrl(from.getPosterPath());
        viewModel.setImageUrl(fullImageUrl);
        return viewModel;
    }

    @NonNull
    public static List<MovieListItemViewModel> create(List<Movie> movieList) {
        List<MovieListItemViewModel> viewModels = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieListItemViewModel viewModel = MovieListItemViewModel.convert(movie);
            viewModels.add(viewModel);
        }
        return viewModels;
    }

}
