package com.revastt.moviecatalogue.data.remote.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvDetail {

	@SerializedName("backdrop_path")
	@Expose
	private String backdropPath;
	@SerializedName("first_air_date")
	@Expose
	private String firstAirDate;
	@SerializedName("genres")
	@Expose
	private List<Genre> genres = null;

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("overview")
	@Expose
	private String overview;

	@SerializedName("poster_path")
	@Expose
	private String posterPath;

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}

	@SerializedName("vote_average")
	@Expose
	private Double voteAverage;


	public TvDetail(String posterPath, Integer id, String name, Double voteAverage, String overview, String firstAirDate, String backdropPath) {
		this.posterPath=posterPath;
		this.id=id;
		this.name=name;
		this.voteAverage=voteAverage;
		this.overview=overview;
		this.firstAirDate=firstAirDate;
		this.backdropPath=backdropPath;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}


	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}



}