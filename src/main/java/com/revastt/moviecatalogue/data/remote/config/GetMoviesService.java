package com.revastt.moviecatalogue.data.remote.config;

import retrofit2.Callback;

public class GetMoviesService {
	private ApiInterface api;

	public GetMoviesService() {
		api = RetrofitBuilder.builder().create(ApiInterface.class);
	}

	public void doGetDataMovies(Callback callback) {

		api.getMovies().enqueue(callback);

	}

}
