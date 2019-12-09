package com.revastt.moviecatalogue.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.local.LocalRepository;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.ApiResponse;
import com.revastt.moviecatalogue.data.remote.RemoteRepository;
import com.revastt.moviecatalogue.data.remote.response.MoviesResult;
import com.revastt.moviecatalogue.data.remote.response.TvResult;
import com.revastt.moviecatalogue.utils.AppExecutors;
import com.revastt.moviecatalogue.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements MovieDataSource {
	private volatile static MovieRepository INSTANCE = null;

	private final LocalRepository localRepository;
	private final RemoteRepository remoteRepository;
	private final AppExecutors appExecutors;

	private MovieRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutors) {
		this.localRepository = localRepository;
		this.remoteRepository = remoteRepository;
		this.appExecutors = appExecutors;
	}

	public static MovieRepository getInstance(LocalRepository localRepository, RemoteRepository remoteData, AppExecutors appExecutors) {
		if (INSTANCE == null) {
			synchronized (MovieRepository.class) {
				if (INSTANCE == null) {
					INSTANCE = new MovieRepository(localRepository, remoteData, appExecutors);
				}
			}
		}
		return INSTANCE;
	}

	@Override
	public LiveData<Resource<List<MovieEntity>>> getMoviesData() {
		return new NetworkBoundResource<List<MovieEntity>, List<MoviesResult>>(appExecutors) {
			@Override
			public LiveData<List<MovieEntity>> loadFromDB() {
				return localRepository.getAllMovie();
			}

			@Override
			public Boolean shouldFetch(List<MovieEntity> data) {
				return (data == null) || (data.size() == 0);
			}

			@Override
			public LiveData<ApiResponse<List<MoviesResult>>> createCall() {
				return remoteRepository.getAllMovies();
			}

			@Override
			public void saveCallResult(List<MoviesResult> movieResponses) {
				List<MovieEntity> movieEntities = new ArrayList<>();

				for (MoviesResult movieResponse : movieResponses) {

					movieEntities.add(new MovieEntity(
							movieResponse.getPosterPath(),
							movieResponse.getId(),
							movieResponse.getTitle(),
							movieResponse.getVoteAverage(),
							movieResponse.getOverview(),
							movieResponse.getReleaseDate(),
							movieResponse.getBackdropPath()));
				}

				localRepository.insertMovie(movieEntities);
			}
		}.asLiveData();
	}


	@Override
	public LiveData<Resource<MovieEntity>> getMoviesDetail(Integer id) {
		return new NetworkBoundResource<MovieEntity, List<MoviesResult>>(appExecutors) {
			@Override
			protected LiveData<MovieEntity> loadFromDB() {
				return localRepository.getMovieById(id);
			}



			@Override
			protected Boolean shouldFetch(MovieEntity modules) {
				return (modules == null) ;
			}

			@Override
			protected LiveData<ApiResponse<List<MoviesResult>>> createCall() {
				return remoteRepository.getAllMoviesById(id);
			}

			@Override
			protected void saveCallResult(List<MoviesResult> movieResponses) {

				List<MovieEntity> movieEntities = new ArrayList<>();

				for (MoviesResult movieResponse : movieResponses) {
					movieEntities.add(new MovieEntity(
							movieResponse.getPosterPath(),
							id,
							movieResponse.getTitle(),
							movieResponse.getVoteAverage(),
							movieResponse.getOverview(),
							movieResponse.getReleaseDate(),
							movieResponse.getBackdropPath()));

				}

				localRepository.insertMovie(movieEntities);

			}
		}.asLiveData();
	}
	@Override
	public void setFavMovies(FavMovieEntity favMovies) {

		Runnable runnable = () -> localRepository.insertMovieFav(favMovies);

		appExecutors.diskIO().execute(runnable);


	}

	@Override
	public void deleteMovieFav(FavMovieEntity movies) {
		Runnable runnable = () -> localRepository.deleteMovieFav(movies);
		appExecutors.diskIO().execute(runnable);
	}

	@Override
	public LiveData<Resource<List<TvEntity>>> getTvData() {
		return new NetworkBoundResource<List<TvEntity>, List<TvResult>>(appExecutors) {
			@Override
			public LiveData<List<TvEntity>> loadFromDB() {
				return localRepository.getAllTv();
			}

			@Override
			public Boolean shouldFetch(List<TvEntity> data) {
				return (data == null) || (data.size() == 0);
			}

			@Override
			public LiveData<ApiResponse<List<TvResult>>> createCall() {
				return remoteRepository.getAllTv();
			}

			@Override
			public void saveCallResult(List<TvResult> tvResponses) {
				List<TvEntity> tvEntities = new ArrayList<>();

				for (TvResult tvResponse : tvResponses) {

					tvEntities.add(new TvEntity(
							tvResponse.getPosterPath(),
							tvResponse.getName(),
							tvResponse.getFirstAirDate(),
							tvResponse.getId(),
							tvResponse.getVoteAverage(),
							tvResponse.getOverview(),
							tvResponse.getBackdropPath()));
				}

				localRepository.insertTv(tvEntities);
			}
		}.asLiveData();
	}

	@Override
	public LiveData<Resource<PagedList<FavMovieEntity>>> getMoviePaged() {
		return new NetworkBoundResource<PagedList<FavMovieEntity>, List<MoviesResult>>(appExecutors) {
			@Override
			protected LiveData<PagedList<FavMovieEntity>> loadFromDB() {
				return new LivePagedListBuilder<>(localRepository.getMoviePaged(), /* page size */ 20).build();
			}

			@Override
			protected Boolean shouldFetch(PagedList<FavMovieEntity> data) {
				return false;
			}

			@Override
			protected LiveData<ApiResponse<List<MoviesResult>>> createCall() {
				return null;
			}

			@Override
			protected void saveCallResult(List<MoviesResult> data) {

			}
		}.asLiveData();
	}


	@Override
	public LiveData<Resource<TvEntity>> getTvDetail(Integer id) {
		return new NetworkBoundResource<TvEntity, List<TvResult>>(appExecutors) {
			@Override
			protected LiveData<TvEntity> loadFromDB() {
				return localRepository.getTvById(id);
			}



			@Override
			protected Boolean shouldFetch(TvEntity modules) {
				return (modules == null) ;
			}

			@Override
			protected LiveData<ApiResponse<List<TvResult>>> createCall() {
				return remoteRepository.getAllTvById(id);
			}

			@Override
			protected void saveCallResult(List<TvResult> tvResponses) {

				List<TvEntity> tvEntities = new ArrayList<>();

				for (TvResult tvResponse : tvResponses) {
					tvEntities.add(new TvEntity(
							tvResponse.getPosterPath(),
							tvResponse.getName(),
							tvResponse.getFirstAirDate(),
							id,
							tvResponse.getVoteAverage(),
							tvResponse.getOverview(),
							tvResponse.getBackdropPath()));

				}

				localRepository.insertTv(tvEntities);

			}
		}.asLiveData();
	}
	@Override
	public void setFavTv(FavTvEntity favTv) {
		Runnable runnable = () -> localRepository.insertTvFav(favTv);
		appExecutors.diskIO().execute(runnable);

	}

	@Override
	public void deleteTvFav(FavTvEntity favTvEntity) {
		Runnable runnable = () -> localRepository.deleteTvFav(favTvEntity);
		appExecutors.diskIO().execute(runnable);
	}

	@Override
	public LiveData<Resource<PagedList<FavTvEntity>>> getTvPaged() {
		return new NetworkBoundResource<PagedList<FavTvEntity>, List<TvResult>>(appExecutors) {
			@Override
			protected LiveData<PagedList<FavTvEntity>> loadFromDB() {
				return new LivePagedListBuilder<>(localRepository.getTvPaged(), /* page size */ 20).build();
			}

			@Override
			protected Boolean shouldFetch(PagedList<FavTvEntity> data) {
				return false;
			}

			@Override
			protected LiveData<ApiResponse<List<TvResult>>> createCall() {
				return null;
			}

			@Override
			protected void saveCallResult(List<TvResult> data) {

			}
		}.asLiveData();
	}

}




