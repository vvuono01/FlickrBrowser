package com.vvuono.flickrbrowser.model;

import com.google.gson.annotations.SerializedName;

public class FlickrPhoto {
    @SerializedName("id")
    String mId;
    @SerializedName("owner")
    String mOwner;
    @SerializedName("secret")
    String mSecret;
    @SerializedName("server")
    int mServer;
    @SerializedName("farm")
    int mFarm;
    @SerializedName("title")
    String mTitle;
    @SerializedName("ispublic")
    int mIsPublic;
    @SerializedName("isfriend")
    int mIsFriend;
    @SerializedName("isfamily")
    int mIsFamily;

    public String getId() {
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

    public int getFarm() {
        return mFarm;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean isPublic() {
        return mIsPublic == 1;
    }

    public boolean isFriend() {
        return mIsFriend == 1;
    }

    public boolean isFamily() {
        return mIsFamily == 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlickrPhoto{");
        sb.append("mId='").append(mId).append('\'');
        sb.append(", mOwner='").append(mOwner).append('\'');
        sb.append(", mSecret='").append(mSecret).append('\'');
        sb.append(", mServer=").append(mServer);
        sb.append(", mFarm=").append(mFarm);
        sb.append(", mTitle='").append(mTitle).append('\'');
        sb.append(", mIsPublic=").append(mIsPublic);
        sb.append(", mIsFriend=").append(mIsFriend);
        sb.append(", mIsFamily=").append(mIsFamily);
        sb.append('}');
        return sb.toString();
    }

    public String getFlickrUrl() {
        final StringBuilder sb = new StringBuilder("https://farm");
        sb.append(mFarm).append(".staticflickr.com/");
        sb.append(mServer).append("/");
        sb.append(mId).append("_");
        sb.append(mSecret).append(".jpg");
        return sb.toString();
    }
}
