package com.revastt.moviecatalogue.data.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDetail implements Parcelable {


	@SerializedName("backdrop_path")
	@Expose
	private String backdropPath;

	@SerializedName("genres")
	@Expose
	private List<Genre> genres = null;

	@SerializedName("id")
	@Expose
	private Integer id;

	@SerializedName("overview")
	@Expose
	private String overview;

	@SerializedName("poster_path")
	@Expose
	private String posterPath;
	@SerializedName("release_date")
	@Expose
	private String releaseDate;

	@SerializedName("title")
	@Expose
	private String title;

	@SerializedName("vote_average")
	@Expose
	private Double voteAverage;


	public MovieDetail(String posterPath, Integer id, String title, Double voteAverage, String overview, String releaseDate, String backdropPath) {
		this.posterPath = posterPath;
		this.id = id;
		this.title = title;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.backdropPath = backdropPath;
	}


	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
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


	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}


	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.backdropPath);
		dest.writeList(this.genres);
		dest.writeValue(this.id);
		dest.writeString(this.overview);
		dest.writeString(this.posterPath);
		dest.writeString(this.releaseDate);
		dest.writeString(this.title);
		dest.writeValue(this.voteAverage);
	}

	protected MovieDetail(Parcel in) {
		this.backdropPath = in.readString();
		this.genres = new ArrayList<Genre>();
		in.readList(this.genres, Genre.class.getClassLoader());
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.overview = in.readString();
		this.posterPath = in.readString();
		this.releaseDate = in.readString();
		this.title = in.readString();
		this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
	}

	public static final Parcelable.Creator<MovieDetail> CREATOR = new Parcelable.Creator<MovieDetail>() {
		@Override
		public MovieDetail createFromParcel(Parcel source) {
			return new MovieDetail(source);
		}

		@Override
		public MovieDetail[] newArray(int size) {
			return new MovieDetail[size];
		}
	};
}