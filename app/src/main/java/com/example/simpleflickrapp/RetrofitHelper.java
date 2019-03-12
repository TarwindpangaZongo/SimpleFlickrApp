package com.example.simpleflickrapp;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitHelper {
    private static OkHttpClient getOkhttpClientWithIntercepter(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    private static Retrofit getRetrofut(){
        return new Retrofit
                .Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(getOkhttpClientWithIntercepter())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private ObservableInterface createUserResponceInterface(){
        return getRetrofut().create(ObservableInterface.class);
    }

    public Observable<UserResponse> getUserResponseObsevable(String numResults, String gender){
        return createUserResponceInterface().fgetUserResponseObservable(numResults,gender);
    }

    public interface ObservableInterface{
        @GET(ApiConstants.PATH_API)
        Observable<UserResponse> fgetUserResponseObservable(
                @Query(ApiConstants.QUERY_RESULTS)String numOfResultsDesired,
                @Query(ApiConstants.QUERY_GENDER)String requestedGender);
    }
}

