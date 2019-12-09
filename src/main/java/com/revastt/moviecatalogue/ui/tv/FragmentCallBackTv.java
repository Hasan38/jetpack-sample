package com.revastt.moviecatalogue.ui.tv;

import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;

interface FragmentCallBackTv {


	void onShareClick(TvEntity movieEntity);
	void onSaveFav(FavTvEntity movieEntity);

}
