package com.revastt.moviecatalogue.ui.favorite.favtv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.vo.Resource;

public class FavTvViewModel extends ViewModel {
	private MovieRepository movieRepository;

	public FavTvViewModel(MovieRepository mMovieRepository) {
		this.movieRepository = mMovieRepository;
	}


	LiveData<Resource<PagedList<FavTvEntity>>> getTvPaged() {
		return movieRepository.getTvPaged();
	}

	void deleteMovie(FavTvEntity movieEntity) {
		movieRepository.deleteTvFav(movieEntity);
	}

	void setFav(FavTvEntity movieEntity) {
		movieRepository.setFavTv(movieEntity);
	}
}
