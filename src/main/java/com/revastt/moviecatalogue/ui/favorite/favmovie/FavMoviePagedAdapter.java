package com.revastt.moviecatalogue.ui.favorite.favmovie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.revastt.moviecatalogue.R;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.remote.config.ConfigApi;
import com.revastt.moviecatalogue.ui.detail.DetailMovieActivity;
import com.revastt.moviecatalogue.utils.GlideApp;

public class FavMoviePagedAdapter extends PagedListAdapter<FavMovieEntity, FavMoviePagedAdapter.FavMovieViewHolder> {

	private FavoritMovieFragmentCallback callback;

	FavMoviePagedAdapter(FavoritMovieFragmentCallback callback) {
		super(DIFF_CALLBACK);
		this.callback = callback;
	}

	@Override
	public void onBindViewHolder(@NonNull final FavMovieViewHolder holder, int position) {
		final FavMovieEntity movie = getItem(position);
		if (movie != null) {
			holder.txtTitle.setText(movie.getTitle());
			holder.txtRelease.setText(movie.getReleaseDate());
			holder.txtOverview.setText(movie.getOverview());

			holder.txtRating.setText(String.valueOf(movie.getVoteAverage()));
			holder.itemView.setOnClickListener(v -> {
				Context context = holder.itemView.getContext();
				Intent intent = new Intent(context, DetailMovieActivity.class);
				intent.putExtra(DetailMovieActivity.DATA_MOVIE, movie.getId());
				context.startActivity(intent);
			});
			GlideApp.with(holder.itemView.getContext()).load(ConfigApi.POSTER_URL + movie.getPosterPath()).apply(RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.ic_error)).into(holder.imgPhoto);
			holder.imgShare.setOnClickListener(v -> {
				FavMovieEntity mv = new FavMovieEntity(
						movie.getPosterPath(),
						movie.getId(),
						movie.getTitle(),
						movie.getVoteAverage(),
						movie.getOverview(),
						movie.getReleaseDate(),
						movie.getBackdropPath());
				callback.onShareClick(mv);

			});
			holder.imgDelete.setOnClickListener(v -> {
				FavMovieEntity mv = new FavMovieEntity(
						movie.getPosterPath(),
						movie.getId(),
						movie.getTitle(),
						movie.getVoteAverage(),
						movie.getOverview(),
						movie.getReleaseDate(),
						movie.getBackdropPath());
				callback.onDelete(mv);

			});

		}
	}
	@NonNull
	@Override
	public FavMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_fav, parent, false);
		return new FavMovieViewHolder (view);
	}


	private static DiffUtil.ItemCallback<FavMovieEntity> DIFF_CALLBACK =
			new DiffUtil.ItemCallback<FavMovieEntity>() {
				@Override
				public boolean areItemsTheSame(@NonNull FavMovieEntity oldItem, @NonNull FavMovieEntity newItem) {
					return oldItem.getId().equals(newItem.getId());
				}

				@SuppressLint("DiffUtilEquals")
				@Override
				public boolean areContentsTheSame(@NonNull FavMovieEntity oldItem, @NonNull FavMovieEntity newItem) {
					return oldItem.equals(newItem);
				}
			};

	FavMovieEntity getItemById(int swipedPosition) {
		return getItem(swipedPosition);
	}

	class FavMovieViewHolder extends RecyclerView.ViewHolder {
		private TextView txtTitle;
		private TextView txtRelease;
		private TextView txtRating;
		private ImageView imgPhoto;
		private ImageView imgShare;
		private ImageView imgDelete;
		private TextView txtOverview;

		FavMovieViewHolder(View itemView) {
			super(itemView);
			imgPhoto = itemView.findViewById(R.id.img_item_photo);
			txtTitle = itemView.findViewById(R.id.movies_item_title);
			txtRelease = itemView.findViewById(R.id.txtReleaseDate);
			txtRating = itemView.findViewById(R.id.movies_item_rating);
			txtOverview= itemView.findViewById(R.id.movies_item_overview);
			imgShare=itemView.findViewById(R.id.imgShare);
			imgDelete=itemView.findViewById(R.id.imgDelete);
		}
	}
}