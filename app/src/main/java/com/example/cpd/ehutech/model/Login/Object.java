package com.example.cpd.ehutech.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("results")
    @Expose
    private Results_ results;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Results_ getResults() {
        return results;
    }

    public void setResults(Results_ results) {
        this.results = results;
    }
}
