package com.example.zubinthakkar.asktoagriexpert;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.Query;

import java.util.List;

/**
 * Created by sapan on 16-03-2018.
 */

public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.QueryViewHolder>{

    private Context mCtx;
    private List<Qlist> queryList;

    public QueryAdapter(Context mCtx, List<Qlist> queryList) {
        this.mCtx = mCtx;
        this.queryList = queryList;
    }

    @Override
    public QueryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.listlayoutview, null);
        return new QueryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QueryViewHolder holder, final int position) {
        final Qlist qlist = queryList.get(position);

        holder.query.setText(qlist.getQuery());
        holder.farmer.setText(qlist.getFarmer());

        holder.cv_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(mCtx,ExpertAnswered.class);
                //i.putExtra("val", "name");
                i.putExtra("val",queryList.get(position).getQuery());
                 mCtx.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return queryList.size();
    }


    class QueryViewHolder extends RecyclerView.ViewHolder{


        TextView query,farmer;
        CardView cv_list;

        public QueryViewHolder(View itemView) {
            super(itemView);

            query = itemView.findViewById(R.id.qlist);
            farmer = itemView.findViewById(R.id.farmer_id);

            cv_list=itemView.findViewById(R.id.cv_list);


        }
    }
}
