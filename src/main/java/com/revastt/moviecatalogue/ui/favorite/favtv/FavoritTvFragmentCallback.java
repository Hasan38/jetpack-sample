package com.revastt.moviecatalogue.ui.favorite.favtv;

import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;


interface FavoritTvFragmentCallback {
	void onShareClick(FavTvEntity movieEntity);
	void onDelete(FavTvEntity movieEntity);
}
