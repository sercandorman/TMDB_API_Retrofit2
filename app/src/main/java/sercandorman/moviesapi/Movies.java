package sercandorman.moviesapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movies {

    @SerializedName("original_title")
    @Expose
    private String movieName;

    @SerializedName("poster_path")
    @Expose
    private String imgUrl;

    public Movies(String movieName, String imgUrl) {
        this.movieName = movieName;
        this.imgUrl = imgUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
