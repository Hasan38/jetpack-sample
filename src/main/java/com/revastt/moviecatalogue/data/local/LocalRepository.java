package com.revastt.moviecatalogue.data.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.local.room.MovieDao;

import java.util.List;

public class LocalRepository {

	private static LocalRepository INSTANCE;
	private final MovieDao movieDao;

	private LocalRepository(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	public static LocalRepository getInstance(MovieDao movieDao) {
		if (INSTANCE == null) {
			INSTANCE = new LocalRepository(movieDao);
		}
		return INSTANCE;
	}

	public LiveData<List<MovieEntity>> getAllMovie() {
		return movieDao.getAllMovie();
	}
	public LiveData<MovieEntity> getMovieById(final Integer id) {
		return movieDao.getMovieById(id);
	}
	public void insertMovie(List<MovieEntity> movie) {
		movieDao.insertMovie(movie);
	}
	public void insertMovieFav(FavMovieEntity movie) {
		movieDao.insertMovieFav(movie);
	}
	public void deleteMovieFav(FavMovieEntity movie) {
		movieDao.deleteMovieFav(movie);
	}
	public DataSource.Factory<Integer, FavMovieEntity> getMoviePaged() {
		return movieDao.getMovieAsPaged();
	}


	public LiveData<List<TvEntity>> getAllTv() {
		return movieDao.getAllTv();
	}
	public LiveData<TvEntity> getTvById(final Integer id) {
		return movieDao.getTvById(id);
	}
	public void insertTv(List<TvEntity> tv) {
		movieDao.insertTv(tv);
	}
	public void insertTvFav(FavTvEntity tv) {
		movieDao.insertTvFav(tv);
	}
	public void deleteTvFav(FavTvEntity tv) {
		movieDao.deleteTvFav(tv);
	}
	public DataSource.Factory<Integer, FavTvEntity> getTvPaged() {
		return movieDao.getTvAsPaged();
	}








}