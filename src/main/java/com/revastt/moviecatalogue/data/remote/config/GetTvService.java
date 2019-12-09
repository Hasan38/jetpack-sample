package com.revastt.moviecatalogue.data.remote.config;


import retrofit2.Callback;

public class GetTvService {
	private ApiInterface api;

	public GetTvService() {
		api = RetrofitBuilder.builder().create(ApiInterface.class);
	}

	public void doGetDataTv(Callback callback) {

		api.getTvData().enqueue(callback);

	}
}
