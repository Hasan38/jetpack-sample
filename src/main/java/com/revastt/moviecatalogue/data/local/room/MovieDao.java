package com.revastt.moviecatalogue.data.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;

import java.util.List;
@Dao
public interface MovieDao {
	//Movies
	@WorkerThread
	@Query("SELECT * FROM movieentities")
	LiveData<List<MovieEntity>> getAllMovie();

	@Transaction
	@Query("SELECT * FROM movieentities WHERE id = :id")
	LiveData<MovieEntity> getMovieById(Integer id);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	long[] insertMovie(List<MovieEntity> movie);


	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertMovieFav(FavMovieEntity favMovieEntity);

	@Delete
	void deleteMovieFav(FavMovieEntity favMovieEntity);

	@Query("SELECT * FROM favmovieentities ")
	DataSource.Factory<Integer,FavMovieEntity> getMovieAsPaged();


	//Tv
	@Transaction
	@Query("SELECT * FROM tventities")
	LiveData<List<TvEntity>> getAllTv();

	@Query("SELECT * FROM tventities WHERE id = :id")
	LiveData<TvEntity> getTvById(Integer id);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	long[] insertTv(List<TvEntity> tv);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertTvFav(FavTvEntity favTvEntity);

	@Delete
	void deleteTvFav(FavTvEntity favTvEntity);

	@Query("SELECT * FROM favtventities ")
	DataSource.Factory<Integer,FavTvEntity> getTvAsPaged();


}
