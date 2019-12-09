package com.revastt.moviecatalogue.data.remote.config;

import com.revastt.moviecatalogue.data.remote.response.Movies;
import com.revastt.moviecatalogue.data.remote.response.Tv;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {


    @GET(ConfigApi.GET_MOVIES)
    Call<Movies> getMovies();

    @GET(ConfigApi.GET_TV)
    Call<Tv> getTvData();

    @GET(ConfigApi.MOVIES_DETAIL+"{id}?api_key="+ConfigApi.apiKey+"&language=en-US")
    Call<Movies> getMoviesDetail(
            @Path("id") int id
    );

    @GET(ConfigApi.TV_DETAIL+"{id}?api_key="+ConfigApi.apiKey+"&language=en-US")
    Call<Tv> getTvDetail(
            @Path("id") int id
    );
}
