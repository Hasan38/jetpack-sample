package com.revastt.moviecatalogue.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.utils.FakeDataDummy;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvViewModelTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private TvViewModel viewModel;

	private MovieRepository movieRepository = mock(MovieRepository.class);

	@Before
	public void setUp() {
		viewModel = new TvViewModel(movieRepository);
	}

	@Test
	public void getTv() {

		Resource<List<TvEntity>> resource = Resource.success(FakeDataDummy.generateDummyTv());
		MutableLiveData<Resource<List<TvEntity>>> dummyMovies = new MutableLiveData<>();
		dummyMovies.setValue(resource);

		when(movieRepository.getTvData()).thenReturn(dummyMovies);

		Observer<Resource<List<TvEntity>>> observer = mock(Observer.class);

		viewModel.setUsername();

		viewModel.movie.observeForever(observer);

		verify(observer).onChanged(resource);
	}
}