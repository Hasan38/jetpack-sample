package com.revastt.moviecatalogue.ui.tv;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.vo.Resource;

import java.util.List;

public class TvViewModel extends ViewModel {
	private MovieRepository movieRepository;
	private MutableLiveData<String> mLogin = new MutableLiveData<>();

	public TvViewModel(MovieRepository AmovieRepository) {
		this.movieRepository = AmovieRepository;
	}

	LiveData<Resource<List<TvEntity>>> movie = Transformations.switchMap(mLogin,
			data -> movieRepository.getTvData());

	void setUsername() {
		mLogin.setValue("hasan");
	}

	void setFav(FavTvEntity fav) {
		movieRepository.setFavTv(fav);
	}
}