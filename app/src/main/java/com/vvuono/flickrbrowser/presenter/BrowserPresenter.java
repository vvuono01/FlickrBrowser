package com.vvuono.flickrbrowser.presenter;

import com.google.gson.Gson;
import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.model.FlickrApiInterface;
import com.vvuono.flickrbrowser.model.FlickrPhoto;
import com.vvuono.flickrbrowser.model.FlickrPhotoResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String API_KEY = "72600809d205a8d20a6effeec1027aea";
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
                        FlickrPhotoResponse photoResponse = gson.fromJson(json, FlickrPhotoResponse.class);

                        List<String> urls = new ArrayList<>();
                        FlickrPhoto[] photos = photoResponse.getPhotos().getPhotos();
                        for (int i = 0; i < photos.length; i++) {
                            urls.add(photos[i].getFlickrUrl());
                        }

                        getView().onImagesLoaded(urls);
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
