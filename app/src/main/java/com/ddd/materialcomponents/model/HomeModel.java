package com.ddd.materialcomponents.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by S.C. on 23/05/18.
 */

public class HomeModel implements Parcelable{
    private int image;
    private int description;
    private int propertyName;

    public HomeModel() {
    }

    public HomeModel(int image, int description, int propertyName) {
        this.image = image;
        this.description = description;
        this.propertyName = propertyName;
    }

    protected HomeModel(Parcel in) {
        image = in.readInt();
        description = in.readInt();
        propertyName = in.readInt();
    }

    public static final Creator<HomeModel> CREATOR = new Creator<HomeModel>() {
        @Override
        public HomeModel createFromParcel(Parcel in) {
            return new HomeModel(in);
        }

        @Override
        public HomeModel[] newArray(int size) {
            return new HomeModel[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(int propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeInt(description);
        parcel.writeInt(propertyName);
    }
}
