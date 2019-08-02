package com.faldifavian.p3ka.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faldifavian.p3ka.R;
import com.faldifavian.p3ka.model.Item;

import java.util.List;

public class PenyakitAdapter extends RecyclerView.Adapter<PenyakitAdapter.MyHolder> {
    List<Item> mList;
    Context ctx;


    public PenyakitAdapter(Context ctx,List<Item> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_penyakit,viewGroup,false);
        final MyHolder holder = new MyHolder(layout);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Item penyakitList = mList.get(i);
        myHolder.namapenyakit.setText(penyakitList.getNama_penyakit());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView namapenyakit;
        public MyHolder(View v)
        {
            super(v);

            namapenyakit  = v.findViewById(R.id.namapenyakit);
        }

    }
}
