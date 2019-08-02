package com.faldifavian.p3ka.API;

import com.faldifavian.p3ka.model.PenyakitModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIPenyakitService {

    //read data
    @GET("19typp")
    Call<PenyakitModel> getPenyakit();
}
