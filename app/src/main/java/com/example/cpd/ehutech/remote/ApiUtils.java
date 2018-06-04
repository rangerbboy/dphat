package com.example.cpd.ehutech.remote;

import com.example.cpd.ehutech.service.APIService;

public class ApiUtils {
    public static final String BASE_URL = "https://dacsdacs.herokuapp.com/api/v1/";
    public static APIService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
