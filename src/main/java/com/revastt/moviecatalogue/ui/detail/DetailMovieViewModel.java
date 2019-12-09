package com.revastt.moviecatalogue.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.vo.Resource;

public class DetailMovieViewModel extends ViewModel {
	private MovieRepository movieRepository;
	private MutableLiveData<Integer> id= new MutableLiveData<>();

	public LiveData<Resource<MovieEntity>> movie = Transformations.switchMap(id,
			id-> movieRepository.getMoviesDetail(id));

	public DetailMovieViewModel(MovieRepository mAcademyRepository) {
		this.movieRepository = mAcademyRepository;
	}

	public Integer getId() {
		if (id.getValue() == null) return null;
		return id.getValue();
	}

	public void setId(Integer id) {
		this.id.setValue(id);
	}


	void setFav(FavMovieEntity fav) {
		// Kode di bawah menggunakan tanda seru (!),
		// karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak

		movieRepository.setFavMovies(fav);
	}


}


