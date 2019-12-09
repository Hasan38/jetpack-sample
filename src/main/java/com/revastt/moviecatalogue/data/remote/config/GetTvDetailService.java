package com.revastt.moviecatalogue.data.remote.config;


import retrofit2.Callback;

public class GetTvDetailService {

	private ApiInterface api;

	public GetTvDetailService() {
		api = RetrofitBuilder.builder().create(ApiInterface.class);
	}

	public void doGetDataTvDetail(int id, Callback callback) {

		api.getTvDetail(id).enqueue(callback);

	}
}
