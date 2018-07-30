package com.vvuono.flickrbrowser.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class FlickrPhotoResponse {
    @SerializedName("photos")
    FlickrPhotos mPhotos;

    public FlickrPhotos getPhotos() {
        return mPhotos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlickrPhotoResponse{");
        sb.append("mPhotos=").append(mPhotos);
        sb.append('}');
        return sb.toString();
    }
}
