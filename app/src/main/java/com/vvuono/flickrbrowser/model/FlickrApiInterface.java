package com.vvuono.flickrbrowser.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrApiInterface {
    @GET("rest/?method=flickr.photos.getrecent&format=json")
    Call<ResponseBody> getPhotos(@Query("api_key") String apiKey);
}
