package com.vvuono.flickrbrowser.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class FlickrPhotos {
    @SerializedName("page")
    int mPage;
    @SerializedName("pages")
    int mPages;
    @SerializedName("perpage")
    int mPerPage;
    @SerializedName("total")
    int mTotal;
    @SerializedName("photo")
    FlickrPhoto[] mPhotos;

    public int getPage() {
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

    public FlickrPhoto[] getPhotos() {
        return mPhotos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlickrPhotos{");
        sb.append("mPage=").append(mPage);
        sb.append(", mPages=").append(mPages);
        sb.append(", mPerPage=").append(mPerPage);
        sb.append(", mTotal=").append(mTotal);
        sb.append(", mPhotos=").append(Arrays.toString(mPhotos));
        sb.append('}');
        return sb.toString();
    }
}
