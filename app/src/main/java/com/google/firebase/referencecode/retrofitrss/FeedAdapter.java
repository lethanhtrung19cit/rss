package com.google.firebase.referencecode.retrofitrss;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
{
    public TextView txtTitle, txtPubDate, txtContent;


    private itemClickListener itemClickListener;
    public FeedViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle=(TextView)itemView.findViewById(R.id.txtTitle);
        txtPubDate=(TextView)itemView.findViewById(R.id.txtPubDate);
        txtContent=(TextView)itemView.findViewById(R.id.txtContent);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }
    public void setItemClickListener(itemClickListener itemClickListener)
    {

        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View v)
    {
        itemClickListener.onclick(v, getAdapterPosition(), true);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
public class FeedAdapter extends RecyclerView.Adapter {
    private RssRoot rssRoot;
    private RssChannel rssChannel;
    private Context mContext;
    private ArrayList<RssItem> mExampleList;
    private LayoutInflater inflater;
    public FeedAdapter(RssRoot rssRoot, Context mContext)
    {

        this.rssRoot=rssRoot;
        this.mContext=mContext;
        inflater=LayoutInflater.from(mContext);
    }
//    public FeedAdapter(Context context, ArrayList<RssItem> exampleList) {
//        mContext = context;
//        mExampleList = exampleList;
//    }

    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View itemView=inflater.inflate(R.layout.row, parent, false);
        return new FeedViewHolder(itemView);
    }
    MainActivity mainActivity=new MainActivity();
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FeedViewHolder)holder).txtTitle.setText(rssRoot.getItems().get(position).getTitle());
        ((FeedViewHolder)holder).txtPubDate.setText(rssRoot.getItems().get(position).getPubDate());
        ((FeedViewHolder)holder).txtContent.setText(rssRoot.getItems().get(position).getDescription());
        ((FeedViewHolder)holder).setItemClickListener(new itemClickListener() {
            @Override
            public void onclick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                   // Toast.makeText(mContext, "Link:"+rssRoot.getItems().get(position).getLink(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(mContext.getApplicationContext(), MainActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("linkNews", rssRoot.getItems().get(position).getLink());
                    mContext.getApplicationContext().startActivity(intent);

                }

            };
        });
    }

    public int getItemCount()
    {
        return rssRoot.items.size();
    }
}
