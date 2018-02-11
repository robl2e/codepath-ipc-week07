package com.robl2e.codepathipcassignment7.data.remote.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.robl2e.codepathipcassignment7.data.model.movie.Dates;
import com.robl2e.codepathipcassignment7.data.model.movie.Movie;

import java.util.List;

/**
 * Created by robl2e on 2/10/18.
 */

public class MovieNowPlayingResponse {
    @SerializedName("results")
    @Expose
    private List<Movie> results = null;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("dates")
    @Expose
    private Dates dates;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}



