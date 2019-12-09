package com.revastt.moviecatalogue.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.vo.Resource;



public class DetailTvViewModel extends ViewModel {

	private MovieRepository movieRepository;
	private MutableLiveData<Integer> id= new MutableLiveData<>();
	public LiveData<Resource<TvEntity>> tv = Transformations.switchMap(id,
			id-> movieRepository.getTvDetail(id));

	public DetailTvViewModel(MovieRepository mAcademyRepository) {
		this.movieRepository = mAcademyRepository;
	}

	public Integer getId() {
		if (id.getValue() == null) return null;
		return id.getValue();
	}

	public void setId(Integer id) {
		this.id.setValue(id);
	}


	void setFav(FavTvEntity fav) {
		// Kode di bawah menggunakan tanda seru (!),
		// karena akan mengganti status dari apakah sudah di bookmark atau tidak menjadi apakah sudah siap dibookmark atau tidak

		movieRepository.setFavTv(fav);
	}
}

