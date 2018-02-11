package com.robl2e.codepathipcassignment7.ui.movielist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.robl2e.codepathipcassignment7.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robl2e on 2/10/18.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final Context context;
    private List<MovieListItemViewModel> items = new ArrayList<>();

    public MovieListAdapter(Context context) {
        this.context = context;
    }

    public void setItems(List<MovieListItemViewModel> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieListItemViewModel viewModel = items.get(position);
        holder.bindItem(viewModel);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView descriptionTextView;
        private ImageView imagePosterView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_name);
            descriptionTextView = itemView.findViewById(R.id.text_description);
            imagePosterView = itemView.findViewById(R.id.image_poster);
        }

        public void bindItem(MovieListItemViewModel viewModel) {
            setNameTextView(viewModel);
            setDescriptionTextView(viewModel);
            setImagePosterView(viewModel);
        }

        private void setNameTextView(MovieListItemViewModel viewModel) {
            nameTextView.setText(viewModel.getName());
        }

        private void setDescriptionTextView(MovieListItemViewModel viewModel) {
            descriptionTextView.setText(viewModel.getDescription());
        }

        private void setImagePosterView(MovieListItemViewModel viewModel) {
            Glide.with(imagePosterView.getContext())
                    .load(viewModel.getImageUrl())
                    .asBitmap()
                    .into(imagePosterView);
        }
    }
}
