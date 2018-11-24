package sercandorman.moviesapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Movies> movies;
    private Context context;

    public DataAdapter(Context context, ArrayList<Movies> movies) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dynamic_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.movieName.setText(movies.get(i).getMovieName());
        Picasso.get().load(movies.get(i).getImgUrl()).resize(185, 230).into(viewHolder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView movieName;
        private ImageView moviePoster;

        public ViewHolder(View view) {
            super(view);

            movieName = (TextView) view.findViewById(R.id.movieNameTV);
            moviePoster = (ImageView) view.findViewById(R.id.moviePosterIV);
        }
    }
}
