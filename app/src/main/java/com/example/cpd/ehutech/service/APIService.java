package com.example.cpd.ehutech.service;

import com.example.cpd.ehutech.model.Login.Post;
import com.example.cpd.ehutech.model.Login.TrangThai;
import com.example.cpd.ehutech.model.SV5T.Row;
import com.example.cpd.ehutech.model.SV5T.TTinTChiSV5T;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
    @POST("auth/login")
    Call<TrangThai> login_mssv(@Body Post post);

    @GET("sinhvien_5t/mssv/{mssv}?fields=[\"$all\"]")
    Call<TTinTChiSV5T> getTTinTChiSV5T(@Path("mssv") String mssv, @Header("Authorization") String token);

    @POST("sinhvien_5t")
    Call<TTinTChiSV5T> dkyTTinTChiSV5T(@Header("Authorization") String token, @Body Row row);
}