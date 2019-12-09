package com.revastt.moviecatalogue.ui.movie;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {
	private MovieRepository movieRepository;
	private MutableLiveData<String> mLogin = new MutableLiveData<>();

	public MovieViewModel(MovieRepository AmovieRepository) {
		this.movieRepository = AmovieRepository;
	}

	LiveData<Resource<List<MovieEntity>>> movie = Transformations.switchMap(mLogin,
			data -> movieRepository.getMoviesData());

	void setUsername() {
		mLogin.setValue("hasan");
	}

	void setFav(FavMovieEntity fav) {
		movieRepository.setFavMovies(fav);
	}

}