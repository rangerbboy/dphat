package com.example.cpd.ehutech.model.SV5T;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("objects")
    @Expose
    private Object objects;

    public Object getObject() {
        return objects;
    }

    public void setObject(Object objects) {
        this.objects = objects;
    }
}
