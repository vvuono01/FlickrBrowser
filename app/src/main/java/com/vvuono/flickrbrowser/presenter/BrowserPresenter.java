package com.vvuono.flickrbrowser.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.model.FlickrApiInterface;
import com.vvuono.flickrbrowser.model.FlickrPhotoResponse;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BrowserPresenter extends BasePresenter<BrowserContract.View>
        implements BrowserContract.Presenter {
    private FlickrApiInterface mFlickrApi;

    @Inject
    public BrowserPresenter() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/")
                .client(okHttpClient)
                .build();
        mFlickrApi = retrofit.create(FlickrApiInterface.class);
    }

    @Override
    public void loadImages() {
        String API_KEY = "72600809d205a8d20a6effeec1027aea"; // TODO
        Call<ResponseBody> photoCall = mFlickrApi.getPhotos(API_KEY);
        try {
            photoCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        String rawJson = response.body().string();
                        String truncatedJson = rawJson.substring(0, rawJson.length() - 1);
                        String json = truncatedJson.replace("jsonFlickrApi(", "");
                        Gson gson = new Gson();
                        FlickrPhotoResponse photos = gson.fromJson(json, FlickrPhotoResponse.class);
                        getView().onImagesLoaded("Success!");
                    } catch (IOException io) {
                        io.printStackTrace();
                        getView().onImagesLoaded("Failure!");
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                    getView().onImagesLoaded("Failure!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            getView().onImagesLoaded("Exception!");
        }
    }
}
