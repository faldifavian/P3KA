package com.faldifavian.p3ka.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIPenyakitEndPoint {
    private static final String BASE_URL = "https://api.myjson.com/bins/";

    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
//            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
