package com.vvuono.flickrbrowser.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlickrPhotoResponse {
    @SerializedName("page")
    String mPage;
    @SerializedName("pages")
    int mPages;
    @SerializedName("perpage")
    int mPerPage;
    @SerializedName("total")
    int mTotal;
    @SerializedName("photos")
    List<FlickrPhoto> mPhotos;

    public FlickrPhotoResponse(String page, int pages, int perPage, int total, List<FlickrPhoto> photos) {
        mPage = page;
        mPages = pages;
        mPerPage = perPage;
        mTotal = total;
        mPhotos = photos;
    }

    public String getPage() {
        return mPage;
    }

    public int getPages() {
        return mPages;
    }

    public int getPerPage() {
        return mPerPage;
    }

    public int getTotal() {
        return mTotal;
    }

    public List<FlickrPhoto> getPhotos() {
        return mPhotos;
    }
}
