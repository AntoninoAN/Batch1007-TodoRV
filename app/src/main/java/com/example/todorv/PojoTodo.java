package com.example.todorv;

import android.os.Parcel;
import android.os.Parcelable;

public class PojoTodo implements Parcelable {
    private String task;
    private String category;

    public PojoTodo(){ }

    protected PojoTodo(Parcel in) {
        task = in.readString();
        category = in.readString();
    }

    public static final Creator<PojoTodo> CREATOR = new Creator<PojoTodo>() {
        @Override
        public PojoTodo createFromParcel(Parcel in) {
            return new PojoTodo(in);
        }

        @Override
        public PojoTodo[] newArray(int size) {
            return new PojoTodo[size];
        }
    };

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(task);
        parcel.writeString(category);
    }
}
