package com.robl2e.codepathipcassignment7.ui.movielist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.robl2e.codepathipcassignment7.R;
import com.robl2e.codepathipcassignment7.data.model.movie.MovieRepository;
import com.robl2e.codepathipcassignment7.data.remote.AppResponseHandler;
import com.robl2e.codepathipcassignment7.data.remote.movie.MovieNowPlayingResponse;
import com.robl2e.codepathipcassignment7.util.JsonUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MovieListActivity extends AppCompatActivity {
    private RecyclerView listView;
    private MovieListAdapter listAdapter;
    private MovieRepository movieRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        movieRepository = new MovieRepository();
        bindViews();
        setupListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        movieRepository.getMoviesNowPlaying(new AppResponseHandler() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody == null) return;
                String responseData = responseBody.string();
                final MovieNowPlayingResponse nowPlayingResponse =
                        JsonUtils.fromJson(responseData, MovieNowPlayingResponse.class);
                if (nowPlayingResponse == null) return;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setData(MovieListItemViewModel.create(nowPlayingResponse.getResults()));
                    }
                });

            }
        });
    }

    private void bindViews() {
        listView = findViewById(R.id.list_movies);
    }

    private void setupListView() {
        listAdapter = new MovieListAdapter(this);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(listAdapter);
    }

    private void setData(List<MovieListItemViewModel> items) {
        listAdapter.setItems(items);
        listAdapter.notifyDataSetChanged();
    }
}
