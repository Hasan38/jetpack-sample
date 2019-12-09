package com.revastt.moviecatalogue.data.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoviesResult implements Parcelable {



    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public static Creator<MoviesResult> getCREATOR() {
        return CREATOR;
    }

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

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



    public MoviesResult(String posterPath, Integer id, String title, Double voteAverage, String overview, String releaseDate,String backdropPath) {
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
        dest.writeString(this.posterPath);
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeDouble(this.voteAverage);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeString(this.backdropPath);
    }

    protected MoviesResult(Parcel in) {
        this.posterPath = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.voteAverage = in.readDouble();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.backdropPath = in.readString();
    }

    public static final Parcelable.Creator<MoviesResult> CREATOR = new Parcelable.Creator<MoviesResult>() {
        @Override
        public MoviesResult createFromParcel(Parcel source) {
            return new MoviesResult(source);
        }

        @Override
        public MoviesResult[] newArray(int size) {
            return new MoviesResult[size];
        }
    };
}