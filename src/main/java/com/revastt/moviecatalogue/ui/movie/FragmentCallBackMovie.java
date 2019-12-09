package com.revastt.moviecatalogue.ui.movie;

import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;

interface FragmentCallBackMovie {


		void onShareClick(MovieEntity movieEntity);
		void onSaveFav(FavMovieEntity movieEntity);

}
