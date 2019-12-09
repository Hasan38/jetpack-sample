package com.revastt.moviecatalogue.ui.tv;

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
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.config.ConfigApi;
import com.revastt.moviecatalogue.ui.detail.DetailTvActivity;
import com.revastt.moviecatalogue.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
	private Activity activity;
	private ArrayList<TvEntity> movies = new ArrayList<>();
	private FragmentCallBackTv callback;

	TvAdapter(Activity activity, FragmentCallBackTv callback) {

		this.activity = activity;
		this.callback=callback;

	}


	void setListMovie(List<TvEntity> movies) {
		if (movies == null) return;
		this.movies.clear();
		this.movies.addAll(movies);
	}

	@NonNull
	@Override
	public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);

		return new TvViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull final TvViewHolder holder, int position) {
		final TvEntity movie = movies.get(position);
		String title = movie.getName();
		Double voteAverage = movie.getVoteAverage();
		String overview = movie.getOverview();
		String releaseDate = movie.getFirstAirDate();
		holder.txtTitle.setText(title);
		holder.txtRelease.setText(releaseDate);
		holder.txtOverview.setText(overview);

		holder.txtRating.setText(String.valueOf(voteAverage));
		holder.itemView.setOnClickListener(v -> {
			Intent intent = new Intent(activity, DetailTvActivity.class);
			intent.putExtra(DetailTvActivity.DATA_TV, movie.getId());
			activity.startActivity(intent);
		});
		GlideApp.with(holder.itemView.getContext())
				.load(ConfigApi.POSTER_URL+movie.getPosterPath())
				.apply(RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.ic_error))
				.into(holder.imgPhoto);
		holder.imgShare.setOnClickListener(v -> {
			TvEntity mv= new TvEntity(movie.getPosterPath(),
					movie.getName(),
					movie.getFirstAirDate(),
					movie.getId(),
					movie.getVoteAverage(),
					movie.getOverview(),
					movie.getBackdropPath());
			callback.onShareClick(mv);
		});

		holder.imgFav.setOnClickListener(v -> {
			FavTvEntity mv= new FavTvEntity(movie.getPosterPath(),
					movie.getName(),
					movie.getFirstAirDate(),
					movie.getId(),
					movie.getVoteAverage(),
					movie.getOverview(),
					movie.getBackdropPath());
			callback.onSaveFav(mv);
		});

	}

	@Override
	public int getItemCount() {
		return movies.size();
	}

	class TvViewHolder extends RecyclerView.ViewHolder {
		private TextView txtTitle;
		private TextView txtRelease;
		private TextView txtRating;
		private ImageView imgPhoto;
		private ImageView imgShare;
		private ImageView imgFav;
		private TextView txtOverview;

		TvViewHolder(View itemView) {
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