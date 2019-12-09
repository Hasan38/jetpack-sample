package com.revastt.moviecatalogue.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.MovieEntity;
import com.revastt.moviecatalogue.utils.FakeDataDummy;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
	private MovieViewModel viewModel;

	private MovieRepository movieRepository = mock(MovieRepository.class);

	@Before
	public void setUp() {
		viewModel = new MovieViewModel(movieRepository);
	}

	@Test
	public void getMovies() {

		Resource<List<MovieEntity>> resource = Resource.success(FakeDataDummy.generateDummyMovie());
		MutableLiveData<Resource<List<MovieEntity>>> dummyMovies = new MutableLiveData<>();
		dummyMovies.setValue(resource);

		when(movieRepository.getMoviesData()).thenReturn(dummyMovies);

		Observer<Resource<List<MovieEntity>>> observer = mock(Observer.class);

		viewModel.setUsername();

		viewModel.movie.observeForever(observer);

		verify(observer).onChanged(resource);
	}
}