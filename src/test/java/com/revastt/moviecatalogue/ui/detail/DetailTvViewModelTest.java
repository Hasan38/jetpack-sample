package com.revastt.moviecatalogue.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.revastt.moviecatalogue.data.MovieRepository;
import com.revastt.moviecatalogue.data.local.entity.TvEntity;
import com.revastt.moviecatalogue.data.remote.response.TvDetail;
import com.revastt.moviecatalogue.utils.FakeDataDummy;
import com.revastt.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailTvViewModelTest {
	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private DetailTvViewModel viewModel;
	private MovieRepository movieRepository= mock(MovieRepository.class);
	private TvEntity dummyTv = FakeDataDummy.generateDummyTv().get(0);
	private Integer tvId = dummyTv.getId();






	@Before
	public void setUp() {
		viewModel = new DetailTvViewModel(movieRepository);
		viewModel.setId(tvId);
	}

	@Test
	public void getTvDetail() {

		Resource<TvEntity> resource = Resource.success(FakeDataDummy.generateDummyTvDetail(tvId));
		MutableLiveData<Resource<TvEntity>> courseEntities = new MutableLiveData<>();
		courseEntities.setValue(resource);
		when(movieRepository.getTvDetail(tvId)).thenReturn(courseEntities);
		Observer<Resource<TvEntity>> observer = mock(Observer.class);
		viewModel.tv.observeForever(observer);

		verify(observer).onChanged(resource);

	}


}