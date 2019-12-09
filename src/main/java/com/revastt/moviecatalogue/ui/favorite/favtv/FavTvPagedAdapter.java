package com.revastt.moviecatalogue.ui.favorite.favtv;

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
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.remote.config.ConfigApi;
import com.revastt.moviecatalogue.ui.detail.DetailTvActivity;
import com.revastt.moviecatalogue.utils.GlideApp;

public class FavTvPagedAdapter extends PagedListAdapter<FavTvEntity, FavTvPagedAdapter.FavMovieViewHolder> {

	private FavoritTvFragmentCallback callback;

	FavTvPagedAdapter(FavoritTvFragmentCallback callback) {
		super(DIFF_CALLBACK);
		this.callback = callback;
	}

	@Override
	public void onBindViewHolder(@NonNull final FavMovieViewHolder holder, int position) {
		final FavTvEntity movie = getItem(position);
		if (movie != null) {
			holder.txtTitle.setText(movie.getName());
			holder.txtRelease.setText(movie.getFirstAirDate());
			holder.txtOverview.setText(movie.getOverview());

			holder.txtRating.setText(String.valueOf(movie.getVoteAverage()));
			holder.itemView.setOnClickListener(v -> {
				Context context = holder.itemView.getContext();
				Intent intent = new Intent(context, DetailTvActivity.class);
				intent.putExtra(DetailTvActivity.DATA_TV, movie.getId());
				context.startActivity(intent);
			});
			GlideApp.with(holder.itemView.getContext()).load(ConfigApi.POSTER_URL + movie.getPosterPath()).apply(RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.ic_error)).into(holder.imgPhoto);
			holder.imgShare.setOnClickListener(v -> {
				FavTvEntity mv = new FavTvEntity(
						movie.getPosterPath(),
						movie.getName(),
						movie.getFirstAirDate(),
						movie.getId(),
						movie.getVoteAverage(),
						movie.getOverview(),
						movie.getBackdropPath());
				callback.onShareClick(mv);

			});
			holder.imgDelete.setOnClickListener(v -> {
				FavTvEntity Tv = new FavTvEntity(
						movie.getPosterPath(),
						movie.getName(),
						movie.getFirstAirDate(),
						movie.getId(),
						movie.getVoteAverage(),
						movie.getOverview(),
						movie.getBackdropPath());

				callback.onDelete(Tv);

			});

		}
	}
	@NonNull
	@Override
	public FavMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_fav, parent, false);
		return new FavMovieViewHolder (view);
	}


	private static DiffUtil.ItemCallback<FavTvEntity> DIFF_CALLBACK =
			new DiffUtil.ItemCallback<FavTvEntity>() {
				@Override
				public boolean areItemsTheSame(@NonNull FavTvEntity oldItem, @NonNull FavTvEntity newItem) {
					return oldItem.getId().equals(newItem.getId());
				}

				@SuppressLint("DiffUtilEquals")
				@Override
				public boolean areContentsTheSame(@NonNull FavTvEntity oldItem, @NonNull FavTvEntity newItem) {
					return oldItem.equals(newItem);
				}
			};

	FavTvEntity getItemById(int swipedPosition) {
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