package com.faldifavian.p3ka.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.faldifavian.p3ka.API.APIPenyakitEndPoint;
import com.faldifavian.p3ka.API.APIPenyakitService;
import com.faldifavian.p3ka.R;
import com.faldifavian.p3ka.adapter.PenyakitAdapter;
import com.faldifavian.p3ka.model.Item;
import com.faldifavian.p3ka.model.PenyakitModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PenyakitFragment extends Fragment {

    private PenyakitAdapter viewAdapter;
    private List<Item> mItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragment = inflater.inflate(R.layout.fragment_penyakit,container,false);
        final RecyclerView recyclerView = myFragment.findViewById(R.id.rPenyakit);
        viewAdapter = new PenyakitAdapter(getContext(), mItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
        APIPenyakitService api = APIPenyakitEndPoint.getClient().create(APIPenyakitService.class);
        Call<PenyakitModel> call = api.getPenyakit();
        call.enqueue(new Callback<PenyakitModel>() {
            @Override
            public void onResponse(Call<PenyakitModel> call, Response<PenyakitModel> response) {
                mItems = response.body().getItem();
                viewAdapter = new PenyakitAdapter(getContext(),mItems);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<PenyakitModel> call, Throwable t) {
                Toast.makeText(getContext(),"Maaf Koneksi Internet Anda sedang Gangguan", Toast.LENGTH_SHORT).show();
            }
        });

        return myFragment;
    }
}
