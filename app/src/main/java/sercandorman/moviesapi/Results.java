package sercandorman.moviesapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("results")
    @Expose
    public List<Movies> movies;
}
