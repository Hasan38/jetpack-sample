package com.revastt.moviecatalogue.data.remote.config;


import retrofit2.Callback;

public class GetMoviesDetailService {

	private ApiInterface api;

	public GetMoviesDetailService() {
		api = RetrofitBuilder.builder().create(ApiInterface.class);
	}

	public void doGetDataMoviesDetail(int id,Callback callback) {

		api.getMoviesDetail(id).enqueue(callback);

	}
}
