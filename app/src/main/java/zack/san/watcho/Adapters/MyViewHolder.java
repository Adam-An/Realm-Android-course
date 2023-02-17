package zack.san.watcho.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import zack.san.watcho.R;

public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView title;
    TextView episodes;
    ImageView animeImg;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.animeName);
        episodes = itemView.findViewById(R.id.animeEpisodes);
        animeImg = itemView.findViewById(R.id.animeImg);


    }
}
