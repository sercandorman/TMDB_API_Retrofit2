package sercandorman.moviesapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    String baseUrl = "https://api.themoviedb.org/3/";
    String base_img_url = "https://image.tmdb.org/t/p/w185/";
    String apiKey = "YOUR_API_KEY_HERE";
    String filter = "&language=tr-TR" +
            "&sort_by=popularity.desc" +
            "&include_adult=false" +
            "&include_video=false" +
            "&page=1" +  // SAYACA BAGLANIP PAGE SAYISI KADAR ARTTIRILARAK TUM SONUCLAR GOSTERILEBILIR...
            "&primary_release_year=2020" +
            "&year=2020";

    @GET("discover/movie" + "?api_key=" + apiKey + filter)
            Call<Results> getResults();
}
