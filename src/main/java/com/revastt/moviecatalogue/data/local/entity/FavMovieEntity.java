package com.revastt.moviecatalogue.data.local.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favmovieentities")
public class FavMovieEntity {
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	private Integer id;

	@ColumnInfo(name = "title")
	private String title;

	@ColumnInfo(name = "voteAverage")
	private Double voteAverage;

	@ColumnInfo(name = "overview")
	private String overview;

	@ColumnInfo(name = "releaseDate")
	private String releaseDate;

	@ColumnInfo(name = "posterPath")
	private String posterPath;

	@ColumnInfo(name = "backdropPath")
	private String backdropPath;


	public FavMovieEntity(@NonNull String posterPath, Integer id, String title, Double voteAverage, String overview, String releaseDate, String backdropPath) {
		this.posterPath = posterPath;
		this.id = id;
		this.title = title;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.backdropPath = backdropPath;
	}

	@NonNull
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPosterPath() {
		return this.posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}


	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}


}
