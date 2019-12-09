package com.revastt.moviecatalogue.ui.favorite.favmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavMovieEntity;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavMovieViewModelTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private MovieRepository movieRepository = mock(MovieRepository.class);
	private FavMovieViewModel viewModel;

	@Before
	public void setUp() {
		viewModel = new FavMovieViewModel(movieRepository);
	}

	@Test
	public void getFavMovie() {

		MutableLiveData<Resource<PagedList<FavMovieEntity>>> dummyCourse = new MutableLiveData<>();
		PagedList pagedList = mock(PagedList.class);

		dummyCourse.setValue(Resource.success(pagedList));

		when(movieRepository.getMoviePaged()).thenReturn(dummyCourse);

		Observer observer = mock(Observer.class);

		viewModel.getMoviePaged().observeForever(observer);

		verify(observer).onChanged(Resource.success(pagedList));

	}

}