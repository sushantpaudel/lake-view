package np.com.sushantpaudel.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static np.com.sushantpaudel.testapp.R.id.content_main;

/**
 * Created by sushantpaudel on 1/21/2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder>{
    private List<Album> albumList;
    private Context mContext;
    public PopupClass mPopup;


    public int adapterPosition,recyclerPosition;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView thumbnail;
        public MyViewHolder(View v){
            super(v);
            thumbnail=(ImageView)v.findViewById(R.id.thumbnail);
            title = (TextView)v.findViewById(R.id.title);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (recyclerPosition){
                        case 1:
                            adapterPosition=(int)title.getTag();
                            Toast.makeText(mContext,"Clicked Travel Destinations = "+adapterPosition,Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            adapterPosition=(int)title.getTag();
                            Toast.makeText(mContext,"Clicked Cultural Heritage = "+adapterPosition,Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(mContext,"Invalid one!!",Toast.LENGTH_SHORT).show();
                            break;
                    }
                    Context nContext=view.getContext();
                    Intent init=new Intent(nContext,PopupClass.class);
                    Bundle b = new Bundle();
                    b.putInt("key",Integer.parseInt(Integer.toString(recyclerPosition)+Integer.toString(adapterPosition))); //Your ID
                    init.putExtras(b); //Put your id to your next Intent
                    nContext.startActivity(init);
                }
            });


        }
    }



    public AlbumsAdapter(Context mContext, List<Album> albumList,int recyclerPosition){
        this.albumList=albumList;
        this.mContext = mContext;
        this.recyclerPosition=recyclerPosition;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType){
        // Create a new View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position){
        Album album=albumList.get(position);
        holder.title.setTag(position);
        holder.title.setText(album.getName());
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }


    @Override
    public int getItemCount(){
        return albumList.size();
    }
}
