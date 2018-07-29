package com.vvuono.flickrbrowser.model;

import com.google.gson.annotations.SerializedName;

public class FlickrPhoto {
    @SerializedName("id")
    int mId;
    @SerializedName("owner")
    String mOwner;
    @SerializedName("secret")
    String mSecret;
    @SerializedName("server")
    int mServer;
    @SerializedName("title")
    String mTitle;
    @SerializedName("ispublic")
    boolean mIsPublic;
    @SerializedName("isfriend")
    boolean mIsFriend;
    @SerializedName("isfamily")
    boolean mIsFamily;

    public FlickrPhoto(int id, String owner, String secret, int server, String title, boolean isPublic, boolean isFriend, boolean isFamily) {
        mId = id;
        mOwner = owner;
        mSecret = secret;
        mServer = server;
        mTitle = title;
        mIsPublic = isPublic;
        mIsFriend = isFriend;
        mIsFamily = isFamily;
    }

    public int getId() {
        return mId;
    }

    public String getOwner() {
        return mOwner;
    }

    public String getSecret() {
        return mSecret;
    }

    public int getServer() {
        return mServer;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean isPublic() {
        return mIsPublic;
    }

    public boolean isFriend() {
        return mIsFriend;
    }

    public boolean isFamily() {
        return mIsFamily;
    }
}
