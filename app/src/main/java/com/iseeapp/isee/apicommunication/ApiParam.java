package com.iseeapp.isee.apicommunication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dare.fatimehin on 18/04/17.
 */

public class ApiParam implements Parcelable {
    private String key;
    private String value;


    public ApiParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ApiParam(Parcel in) {
        readFromParcel(in);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(value);
    }

    private void readFromParcel(Parcel in) {
        key = in.readString();
        value = in.readString();
    }

    public static final Parcelable.Creator<ApiParam> CREATOR = new Parcelable.Creator<ApiParam>() {
        @Override
        public ApiParam createFromParcel(Parcel source) {
            return new ApiParam(source);
        }

        @Override
        public ApiParam[] newArray(int size) {
            return new ApiParam[size];
        }
    };

}
