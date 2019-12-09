package com.revastt.moviecatalogue.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.data.remote.response.MovieDetail;
import com.revastt.moviecatalogue.utils.FakeDataDummy;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieViewModelTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private DetailMovieViewModel viewModel;
	private MovieRepository movieRepository= mock(MovieRepository.class);
	private MovieDetail dummyMovie = FakeDataDummy.generateDummyMovieDetail().get(0);
	private Integer moviesId = dummyMovie.getId();






	@Before
	public void setUp() {
		viewModel = new DetailMovieViewModel(movieRepository);
		viewModel.setId(moviesId);
	}

	@Test
	public void getMoviesDetail() {
		Resource<MovieEntity> resource = Resource.success(FakeDataDummy.generateRemoteMovieDetail(moviesId));
		MutableLiveData<Resource<MovieEntity>> courseEntities = new MutableLiveData<>();
		courseEntities.setValue(resource);
		when(movieRepository.getMoviesDetail(moviesId)).thenReturn(courseEntities);
		Observer<Resource<MovieEntity>> observer = mock(Observer.class);
		viewModel.movie.observeForever(observer);

		verify(observer).onChanged(resource);
	}


}