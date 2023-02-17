package zack.san.watcho.Adapters;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import io.realm.RealmResults;
import zack.san.watcho.Anime;
import zack.san.watcho.R;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    RealmResults<Anime> animeArrayList;


    public MyRecyclerViewAdapter() {
    }

    public MyRecyclerViewAdapter(Context context, RealmResults<Anime> animeArrayList) {
        this.context = context;
        this.animeArrayList = animeArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Anime anime = animeArrayList.get(position);
        Uri imageUri = Uri.parse(anime.getImageUrl());
       // Uri imageUri = Uri.parse("https://upload.wikimedia.org/wikipedia/en/b/b9/GTO_volume_1.jpg");
        holder.title.setText(anime.getTitle());
        holder.episodes.setText(String.valueOf(anime.getEpisodes()));
       //holder.animeImg.setImageURI(imageUri);

        Glide.with(holder.itemView.getContext())
                .load(imageUri)
                .into(holder.animeImg);
    }

    @Override
    public int getItemCount() {
        return animeArrayList.size();
    }
}
