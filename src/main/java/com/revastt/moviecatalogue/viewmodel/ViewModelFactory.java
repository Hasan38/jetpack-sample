package com.revastt.moviecatalogue.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.di.Injection;
import com.revastt.moviecatalogue.ui.detail.DetailMovieViewModel;
import com.revastt.moviecatalogue.ui.detail.DetailTvViewModel;
import com.revastt.moviecatalogue.ui.favorite.favmovie.FavMovieViewModel;
import com.revastt.moviecatalogue.ui.favorite.favtv.FavTvViewModel;
import com.revastt.moviecatalogue.ui.movie.MovieViewModel;
import com.revastt.moviecatalogue.ui.tv.TvViewModel;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
	private static volatile ViewModelFactory INSTANCE;

	private final MovieRepository mMovieRepository;

	private ViewModelFactory(MovieRepository movieRepository) {
		mMovieRepository = movieRepository;
	}

	public static ViewModelFactory getInstance(Application application) {
		if (INSTANCE == null) {
			synchronized (ViewModelFactory.class) {
				if (INSTANCE == null) {
					INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
				}
			}
		}
		return INSTANCE;
	}

	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

		if (modelClass.isAssignableFrom(MovieViewModel.class)) {
			//noinspection unchecked
			return (T) new MovieViewModel(mMovieRepository);
		}
		else if (modelClass.isAssignableFrom(TvViewModel.class)) {
			//noinspection unchecked
			return (T) new TvViewModel(mMovieRepository);
		}
		else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
			//noinspection unchecked
			return (T) new DetailMovieViewModel(mMovieRepository);
		}
		else if (modelClass.isAssignableFrom(DetailTvViewModel.class)) {
			//noinspection unchecked
			return (T) new DetailTvViewModel(mMovieRepository);
		}
		else if (modelClass.isAssignableFrom(FavMovieViewModel.class)) {
			//noinspection unchecked
			return (T) new FavMovieViewModel(mMovieRepository);
		}
		else if (modelClass.isAssignableFrom(FavTvViewModel.class)) {
			//noinspection unchecked
			return (T) new FavTvViewModel(mMovieRepository);
		}
		throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
	}
}