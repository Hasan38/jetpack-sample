package com.revastt.moviecatalogue.data.remote.config;

import com.revastt.moviecatalogue.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitBuilder {

	public static Retrofit builder() {
		OkHttpClient.Builder okhttpBuilder = new OkHttpClient().newBuilder();
		okhttpBuilder.connectTimeout(60, TimeUnit.SECONDS);
		okhttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
		okhttpBuilder.readTimeout(60, TimeUnit.SECONDS);

		if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
			interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
			okhttpBuilder.addInterceptor(interceptor);
		}

		return new Retrofit.Builder().baseUrl(ConfigApi.API_URL).client(okhttpBuilder.build()).addConverterFactory(GsonConverterFactory.create()).build();
	}
}