package com.revastt.moviecatalogue.ui.favorite.favmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.vo.Resource;

public class FavMovieViewModel extends ViewModel {
	private MovieRepository movieRepository;

	public FavMovieViewModel(MovieRepository mMovieRepository) {
		this.movieRepository = mMovieRepository;
	}


	LiveData<Resource<PagedList<FavMovieEntity>>> getMoviePaged() {
		return movieRepository.getMoviePaged();
	}

	void deleteMovie(FavMovieEntity movieEntity) {
		movieRepository.deleteMovieFav(movieEntity);
	}

	void setFav(FavMovieEntity movieEntity) {
		movieRepository.setFavMovies(movieEntity);
	}
}
