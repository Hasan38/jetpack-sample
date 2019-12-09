package com.revastt.moviecatalogue.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.vo.Resource;

import java.util.List;

public interface MovieDataSource {





	LiveData<Resource<List<MovieEntity>>> getMoviesData();
	LiveData<Resource<MovieEntity>> getMoviesDetail(Integer moviesId);
	void setFavMovies(FavMovieEntity movies);
	void deleteMovieFav(FavMovieEntity movies);
	LiveData<Resource<PagedList<FavMovieEntity>>> getMoviePaged();


	LiveData<Resource<List<TvEntity>>> getTvData();
	LiveData<Resource<TvEntity>> getTvDetail(Integer moviesId);
	void setFavTv(FavTvEntity tv);
	void deleteTvFav(FavTvEntity tv);
	LiveData<Resource<PagedList<FavTvEntity>>> getTvPaged();










}
