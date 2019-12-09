package com.revastt.moviecatalogue.ui.favorite.favmovie;

import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;


interface FavoritMovieFragmentCallback {
	void onShareClick(FavMovieEntity movieEntity);
	void onDelete(FavMovieEntity movieEntity);
}
