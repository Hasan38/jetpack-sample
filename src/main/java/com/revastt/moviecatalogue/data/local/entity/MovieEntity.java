package com.revastt.moviecatalogue.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movieentities")
public class MovieEntity implements Parcelable {
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
		return posterPath;
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




	public MovieEntity(String posterPath, Integer id, String title, Double voteAverage, String overview, String releaseDate, String backdropPath) {
		this.posterPath = posterPath;
		this.id = id;
		this.title = title;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.backdropPath = backdropPath;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.id);
		dest.writeString(this.title);
		dest.writeDouble(this.voteAverage);
		dest.writeString(this.overview);
		dest.writeString(this.releaseDate);
		dest.writeString(this.posterPath);
		dest.writeString(this.backdropPath);
	}

	protected MovieEntity(Parcel in) {
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.title = in.readString();
		this.voteAverage = in.readDouble();
		this.overview = in.readString();
		this.releaseDate = in.readString();
		this.posterPath = in.readString();
		this.backdropPath = in.readString();
	}

	public static final Parcelable.Creator<MovieEntity> CREATOR = new Parcelable.Creator<MovieEntity>() {
		@Override
		public MovieEntity createFromParcel(Parcel source) {
			return new MovieEntity(source);
		}

		@Override
		public MovieEntity[] newArray(int size) {
			return new MovieEntity[size];
		}
	};
}
