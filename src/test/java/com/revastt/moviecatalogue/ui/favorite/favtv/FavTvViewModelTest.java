package com.revastt.moviecatalogue.ui.favorite.favtv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.FavTvEntity;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavTvViewModelTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private MovieRepository movieRepository = mock(MovieRepository.class);
	private FavTvViewModel viewModel;

	@Before
	public void setUp() {
		viewModel = new FavTvViewModel(movieRepository);
	}

	@Test
	public void getFavTv() {

		MutableLiveData<Resource<PagedList<FavTvEntity>>> dummyCourse = new MutableLiveData<>();
		PagedList pagedList = mock(PagedList.class);

		dummyCourse.setValue(Resource.success(pagedList));

		when(movieRepository.getTvPaged()).thenReturn(dummyCourse);

		Observer observer = mock(Observer.class);

		viewModel.getTvPaged().observeForever(observer);

		verify(observer).onChanged(Resource.success(pagedList));

	}
}