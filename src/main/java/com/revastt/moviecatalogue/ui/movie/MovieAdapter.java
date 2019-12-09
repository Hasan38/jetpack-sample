package com.revastt.moviecatalogue.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.remote.config.ConfigApi;
import com.revastt.moviecatalogue.ui.detail.DetailMovieActivity;
import com.revastt.moviecatalogue.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;



public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
	private Activity activity;
	private ArrayList<MovieEntity> movies = new ArrayList<>();
	private FragmentCallBackMovie callback;

	MovieAdapter(Activity activity, FragmentCallBackMovie callback) {
		this.activity = activity;
		this.callback=callback;

	}


	void setListMovie(List<MovieEntity> movies) {
		if (movies == null) return;
		this.movies.clear();
		this.movies.addAll(movies);
	}

	@NonNull
	@Override
	public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);

		return new MovieViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {

		final MovieEntity movie = movies.get(position);
		String title = movie.getTitle();
		Double voteAverage = movie.getVoteAverage();
		String overview = movie.getOverview();
		String releaseDate = (movie.getReleaseDate());
		holder.txtTitle.setText(title);
		holder.txtRelease.setText(releaseDate);
		holder.txtOverview.setText(overview);

		holder.txtRating.setText(String.valueOf(voteAverage));
		holder.itemView.setOnClickListener(v -> {
			Intent intent = new Intent(activity, DetailMovieActivity.class);
			intent.putExtra(DetailMovieActivity.DATA_MOVIE, movie.getId());
			activity.startActivity(intent);
		});
		GlideApp.with(holder.itemView.getContext())
				.load(ConfigApi.POSTER_URL+movie.getPosterPath())
				.apply(RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.ic_error))
				.into(holder.imgPhoto);
		holder.imgShare.setOnClickListener(v -> {
			MovieEntity mv= new MovieEntity(movie.getPosterPath(),
					movie.getId(),
					movie.getTitle(),
					movie.getVoteAverage(),
					movie.getOverview(),
					movie.getReleaseDate(),
					movie.getBackdropPath());
			callback.onShareClick(mv);
		});

		holder.imgFav.setOnClickListener(v -> {
			FavMovieEntity mv= new FavMovieEntity(movie.getPosterPath(),
					movie.getId(),
					movie.getTitle(),
					movie.getVoteAverage(),
					movie.getOverview(),
					movie.getReleaseDate(),
					movie.getBackdropPath());
			callback.onSaveFav(mv);
		});

	}

	@Override
	public int getItemCount() {
		return movies.size();
	}

	class MovieViewHolder extends RecyclerView.ViewHolder {
		private TextView txtTitle;
		private TextView txtRelease;
		private TextView txtRating;
		private ImageView imgPhoto;
		private ImageView imgShare;
		private ImageView imgFav;
		private TextView txtOverview;

		MovieViewHolder(View itemView) {
			super(itemView);
			imgPhoto = itemView.findViewById(R.id.img_item_photo);
			txtTitle = itemView.findViewById(R.id.movies_item_title);
			txtRelease = itemView.findViewById(R.id.txtReleaseDate);
			txtRating = itemView.findViewById(R.id.movies_item_rating);
			txtOverview= itemView.findViewById(R.id.movies_item_overview);
			imgShare=itemView.findViewById(R.id.imgShare);
			imgFav=itemView.findViewById(R.id.imgFav);
		}
	}


}