package com.revastt.moviecatalogue.data.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvResult implements Parcelable {


	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("first_air_date")
	@Expose
	private String firstAirDate;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("vote_average")
	@Expose
	private Double voteAverage;
	@SerializedName("overview")
	@Expose
	private String overview;
	@SerializedName("poster_path")
	@Expose
	private String posterPath;

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	@SerializedName("backdrop_path")
	@Expose
	private String backdropPath;


	public TvResult(String posterPath, String name, String firstAirDate, Integer id, Double voteAverage, String overview,String backdropPath) {
		this.posterPath = posterPath;
		this.name = name;
		this.firstAirDate = firstAirDate;
		this.id = id;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.backdropPath=backdropPath;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.firstAirDate);
		dest.writeValue(this.id);
		dest.writeValue(this.voteAverage);
		dest.writeString(this.overview);
		dest.writeString(this.posterPath);
	}

	protected TvResult(Parcel in) {
		this.name = in.readString();
		this.firstAirDate = in.readString();
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
		this.overview = in.readString();
		this.posterPath = in.readString();
	}

	public static final Parcelable.Creator<TvResult> CREATOR = new Parcelable.Creator<TvResult>() {
		@Override
		public TvResult createFromParcel(Parcel source) {
			return new TvResult(source);
		}

		@Override
		public TvResult[] newArray(int size) {
			return new TvResult[size];
		}
	};
}