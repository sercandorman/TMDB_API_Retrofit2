package sercandorman.moviesapi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button button;
    List<Movies> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<Results> call = api.getResults();

        call.enqueue(new Callback<Results>() {

            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                try {
                    Results results = response.body();
                    movies = results.movies;
                    initViews();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "INTERNET BAGLANTINIZI KONTROL EDINIZ.", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Movies> moviesList = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), moviesList);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Movies> prepareData() {

        ArrayList<Movies> movies_list = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++) {

            String poster_path = movies.get(i).getImgUrl();
            if (poster_path != null) {
                String movieName = movies.get(i).getMovieName();
                String imgUrl = API.base_img_url + poster_path;
                Movies mov = new Movies(movieName, imgUrl);
                movies_list.add(mov);
            }

        }
        return movies_list;
    }
}
