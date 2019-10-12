package szabist.com.kidsgame;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import szabist.com.kidsgame.Model.Items;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> implements View.OnClickListener{

    Items[] itemses;

    Context context;

    public RecyclerAdapter(Items[] itemses){
        this.itemses= itemses;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_row,parent,false);
        view.setOnClickListener(this);

        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Picasso.with(holder.imageView.getContext()).load(itemses[position].picture).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemses.length;
    }

    @Override
    public void onClick(View view) {
        int itemPosition = ((RecyclerView) view.getParent()).getChildLayoutPosition(view);
        Items items;
        items = itemses[itemPosition];
        Intent i = new Intent(context,home2.class);
        i.putExtra("items", items);
        context.startActivity(i);
    }


    public static class RecyclerViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;

        public RecyclerViewHolder(View view){
            super(view);
            imageView=(ImageView) view.findViewById(R.id.image);
        }
    }
}
