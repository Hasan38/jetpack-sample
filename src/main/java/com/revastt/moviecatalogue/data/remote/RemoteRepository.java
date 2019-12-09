package com.revastt.moviecatalogue.data.remote;

import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.revastt.moviecatalogue.data.remote.config.GetMoviesDetailService;
import com.revastt.moviecatalogue.data.remote.config.GetMoviesService;
import com.revastt.moviecatalogue.data.remote.config.GetTvDetailService;
import com.revastt.moviecatalogue.data.remote.config.GetTvService;
import com.revastt.moviecatalogue.data.remote.response.Movies;
import com.revastt.moviecatalogue.data.remote.response.MoviesResult;
import com.revastt.moviecatalogue.data.remote.response.Tv;
import com.revastt.moviecatalogue.data.remote.response.TvResult;
import com.revastt.moviecatalogue.utils.EspressoIdlingResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository{

	private static RemoteRepository INSTANCE;
	private final long SERVICE_LATENCY_IN_MILLIS = 2000;



	public static RemoteRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RemoteRepository();
		}
		return INSTANCE;
	}

	public LiveData<ApiResponse<List<MoviesResult>>> getAllMovies() {
		EspressoIdlingResource.increment();
		MutableLiveData<ApiResponse<List<MoviesResult>>> resultMovie = new MutableLiveData<>();
		Handler handler = new Handler();
		handler.postDelayed(() -> {

			GetMoviesService service = new GetMoviesService();
			service.doGetDataMovies( new Callback() {
				@Override
				public void onResponse(@Nullable Call call,@Nullable Response response) {

					assert response != null;
					Movies mv = (Movies) response.body();

					if (mv != null) {
						assert response.body() != null;
						resultMovie.setValue(ApiResponse.success(((Movies) response.body()).getResults()));

					}
				}


				@Override
				public void onFailure(@Nullable Call call,@Nullable Throwable t) {

				}
			});




			if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
				EspressoIdlingResource.decrement();
			}
		}, SERVICE_LATENCY_IN_MILLIS);

		return resultMovie;
	}


	public LiveData<ApiResponse<List<MoviesResult>>> getAllMoviesById(Integer id) {

		EspressoIdlingResource.increment();
		MutableLiveData<ApiResponse<List<MoviesResult>>> resultMovies = new MutableLiveData<>();

		Handler handler = new Handler();
		handler.postDelayed(() -> {
			EspressoIdlingResource.increment();


			GetMoviesDetailService service = new GetMoviesDetailService();
			service.doGetDataMoviesDetail(id, new Callback() {
				@Override
				public void onResponse(@Nullable Call call,@Nullable Response response) {

					assert response != null;
					Movies mv = (Movies) response.body();

					if (mv != null) {
							resultMovies.setValue(ApiResponse.success(mv.getResults()));

					}
				}


				@Override
				public void onFailure(@Nullable Call call,@Nullable Throwable t) {

				}
			});


			if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
				EspressoIdlingResource.decrement();
			}
		}, SERVICE_LATENCY_IN_MILLIS);

		return resultMovies;
	}

	public LiveData<ApiResponse<List<TvResult>>> getAllTv() {
		EspressoIdlingResource.increment();
		MutableLiveData<ApiResponse<List<TvResult>>> resultTv = new MutableLiveData<>();
		Handler handler = new Handler();
		handler.postDelayed(() -> {
			GetTvService service = new GetTvService();
			service.doGetDataTv(new Callback() {
				@Override
				public void onResponse(@Nullable Call call,@Nullable Response response) {
					assert response != null;
					Tv mv = (Tv) response.body();

					if (mv != null) {
						assert response.body() != null;
						resultTv.setValue(ApiResponse.success(((Tv) response.body()).getResults()));

					}
				}

				@Override
				public void onFailure(@Nullable Call call,@Nullable Throwable t) {

				}
			});

			if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
				EspressoIdlingResource.decrement();
			}
		}, SERVICE_LATENCY_IN_MILLIS);

		return resultTv;
	}

	public LiveData<ApiResponse<List<TvResult>>> getAllTvById(Integer id) {

		EspressoIdlingResource.increment();
		MutableLiveData<ApiResponse<List<TvResult>>> resultTv = new MutableLiveData<>();

		Handler handler = new Handler();
		handler.postDelayed(() -> {

					GetTvDetailService service = new GetTvDetailService();
					service.doGetDataTvDetail(id, new Callback() {
						@Override
						public void onResponse(@Nullable Call call,@Nullable Response response) {

							assert response != null;
							Tv mv = (Tv) response.body();

							if (mv != null) {
								assert response.body() != null;
								resultTv.setValue(ApiResponse.success(((Tv) response.body()).getResults()));

							}
						}

						@Override
						public void onFailure(@Nullable Call call,@Nullable Throwable t) {

						}
					});


			if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
				EspressoIdlingResource.decrement();
			}
		}, SERVICE_LATENCY_IN_MILLIS);

		return resultTv;
	}

}