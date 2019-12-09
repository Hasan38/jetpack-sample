package com.revastt.moviecatalogue.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tventities")
public class TvEntity implements Parcelable {

		@PrimaryKey
		@NonNull
		@ColumnInfo(name = "id")
		private Integer id;

		@ColumnInfo(name = "name")
		private String name;

		@ColumnInfo(name = "voteAverage")
		private Double voteAverage;

		@ColumnInfo(name = "overview")
		private String overview;

		@ColumnInfo(name = "firstAirDate")
		private String firstAirDate;

		@ColumnInfo(name = "posterPath")
		private String posterPath;

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	@ColumnInfo(name = "backdropPath")
		private String backdropPath;


	public TvEntity(String posterPath, String name, String firstAirDate, Integer id, Double voteAverage, String overview,String backdropPath) {
		this.name = name;
		this.firstAirDate = firstAirDate;
		this.id = id;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.posterPath = posterPath;
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

	protected TvEntity(Parcel in) {
		this.name = in.readString();
		this.firstAirDate = in.readString();
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
		this.overview = in.readString();
		this.posterPath = in.readString();
	}

	public static final Parcelable.Creator<TvEntity> CREATOR = new Parcelable.Creator<TvEntity>() {
		@Override
		public TvEntity createFromParcel(Parcel source) {
			return new TvEntity(source);
		}

		@Override
		public TvEntity[] newArray(int size) {
			return new TvEntity[size];
		}
	};
}
