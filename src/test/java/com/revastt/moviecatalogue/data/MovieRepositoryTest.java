package com.revastt.moviecatalogue.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.local.LocalRepository;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.RemoteRepository;
import com.revastt.moviecatalogue.ui.favorite.favmovie.FavMovieViewModel;
import com.revastt.moviecatalogue.utils.FakeDataDummy;
import com.revastt.moviecatalogue.utils.InstantAppExecutors;
import com.revastt.moviecatalogue.utils.LiveDataTestUtil;
import com.revastt.moviecatalogue.utils.PagedListUtil;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieRepositoryTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private LocalRepository local = mock(LocalRepository.class);
	private RemoteRepository remote = mock(RemoteRepository.class);
	private InstantAppExecutors instantAppExecutors = mock(InstantAppExecutors.class);
	private FakeMovieRepository fakeMovieRepository = new FakeMovieRepository(local, remote, instantAppExecutors);
	private ArrayList<MovieEntity> movieResponses = FakeDataDummy.generateDummyMovie();
	private Integer movieId = movieResponses.get(0).getId();
	private ArrayList<TvEntity> tvResponses = FakeDataDummy.generateDummyTv();
	private Integer tvId = tvResponses.get(0).getId();
	private List<FavMovieEntity> favMovieEntities= FakeDataDummy.generateDummyMovieFav();
	private List<FavTvEntity> favTvEntities= FakeDataDummy.generateDummyTvFav();


	@Test
	public void getAllMovies() {
		MutableLiveData<List<MovieEntity>> dummyMovie = new MutableLiveData<>();
		dummyMovie.setValue(FakeDataDummy.generateDummyMovie());

		when(local.getAllMovie()).thenReturn(dummyMovie);

		Resource<List<MovieEntity>> result = LiveDataTestUtil.getValue(fakeMovieRepository.getMoviesData());

		verify(local).getAllMovie();
		assertNotNull(result.data);
		assertEquals(movieResponses.size(), result.data.size());
	}
	@Test
	public void getAllTv() {
		MutableLiveData<List<TvEntity>> dummyTv = new MutableLiveData<>();
		dummyTv.setValue(FakeDataDummy.generateDummyTv());

		when(local.getAllTv()).thenReturn(dummyTv);

		Resource<List<TvEntity>> result = LiveDataTestUtil.getValue(fakeMovieRepository.getTvData());

		verify(local).getAllTv();
		assertNotNull(result.data);
		assertEquals(tvResponses.size(), result.data.size());
	}

	@Test
	public void getMovieById() {
		MutableLiveData<MovieEntity> dummyModules = new MutableLiveData<>();
		dummyModules.setValue(FakeDataDummy.generateRemoteMovieDetail(movieId));

		when(local.getMovieById(movieId)).thenReturn(dummyModules);

		Resource<MovieEntity> result = LiveDataTestUtil.getValue(fakeMovieRepository.getMoviesDetail(movieId));

		verify(local).getMovieById(movieId);
		assertNotNull(result.data);
		assertEquals(movieResponses.size(), 4);
	}


	@Test
	public void getTvById() {
		MutableLiveData<TvEntity> dummyModules = new MutableLiveData<>();
		dummyModules.setValue(FakeDataDummy.generateDummyTvDetail(tvId));

		when(local.getTvById(tvId)).thenReturn(dummyModules);

		Resource<TvEntity> result = LiveDataTestUtil.getValue(fakeMovieRepository.getTvDetail(tvId));

		verify(local).getTvById(tvId);
		assertNotNull(result.data);
		assertEquals(movieResponses.size(), 4);
	}

	@Test
	public void getFavMovie() {

		DataSource.Factory dataSourceFactory = mock(DataSource.Factory.class);

		when(local.getMoviePaged()).thenReturn(dataSourceFactory);
		fakeMovieRepository.getMoviePaged();
		Resource<PagedList<FavMovieEntity>> result = Resource.success(PagedListUtil.mockPagedList(favMovieEntities));

		verify(local).getMoviePaged();
		assertNotNull(result.data);
		assertEquals(favMovieEntities.size(), result.data.size());
	}
	@Test
	public void getFavTv() {

		DataSource.Factory dataSourceFactory = mock(DataSource.Factory.class);

		when(local.getTvPaged()).thenReturn(dataSourceFactory);
		fakeMovieRepository.getTvPaged();
		Resource<PagedList<FavTvEntity>> result = Resource.success(PagedListUtil.mockPagedList(favTvEntities));

		verify(local).getTvPaged();
		assertNotNull(result.data);
		assertEquals(favTvEntities.size(), result.data.size());
	}
}