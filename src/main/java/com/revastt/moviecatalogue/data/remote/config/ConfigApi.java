package com.revastt.moviecatalogue.data.remote.config;


import com.revastt.moviecatalogue.BuildConfig;

public class ConfigApi {
    static final String apiKey = BuildConfig.TMDB_API_KEY;
    static final String API_URL = "https://api.themoviedb.org";
    static final String GET_MOVIES = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&language=en-Us";
    static final String GET_TV=  "https://api.themoviedb.org/3/discover/tv?api_key=" + apiKey + "&language=en-US";
    public static final String POSTER_URL = "https://image.tmdb.org/t/p/w185";
    static final String MOVIES_DETAIL="https://api.themoviedb.org/3/movie/";
    static final String TV_DETAIL="https://api.themoviedb.org/3/tv/";
    public static final String IMAGE_BACK_URL = "https://image.tmdb.org/t/p/w780";


}


